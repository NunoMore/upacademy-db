package repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.Person;

@Named("personRepo")
@Transactional
@ApplicationScoped
public class PersonRepository {
	
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
	
}
