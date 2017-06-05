package service;

import java.util.Collection;

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

	public Person createPerson(Person person){
		em.persist(person);
		return person;
	}
	
	public Collection<Person> readPerson(){
		Query query = em.createQuery("Select e from Person e");
		return (Collection<Person>) query.getResultList();
	}
//	public Person updatePerson(Person person){
//		em.merge(person);
//		return person;
//	}
	public void removePerson(Person person){
		person = em.find(Person.class,person.getID());
		em.remove(person);
	}
}
