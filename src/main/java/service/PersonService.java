package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.Person;

@Named("personService")
@Transactional
@RequestScoped
public class PersonService {
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;

	public void createPerson(Person person){
		em.persist(person);
	}
	
	public List<Person> readPerson(){
		Query query = em.createQuery("Select e from Person e");
		return (List<Person>) query.getResultList();
	}
	public void updatePerson(Person person){
		em.merge(person);
		
	}
	public void removePerson(Person person){
		person = em.find(Person.class,person.getID());
		em.remove(person);
	}
	public void addFavorites(Person person, Person favorite){
		long ID = favorite.getID();	

		person.getFavoritesList().add(ID);
		person.setFavoritesList(person.getFavoritesList());
		
		updatePerson(person);
	}
	public void removeFavorites(Person person,Person favorite){
		long ID = favorite.getID();
		
		if(person.getFavoritesList().contains(ID)){
			person.getFavoritesList().remove(ID);
		}else{
			throw new IllegalArgumentException("This person is not in your favorites list");
		}
		
	}
}
