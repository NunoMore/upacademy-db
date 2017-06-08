package repository;

import java.util.List;

import javax.annotation.PostConstruct;
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
	
	@PostConstruct
	public void initAdmim(){
		final Person admin = new Person();
		admin.setPassword("admin");
		admin.setUsername("admin");
		createPerson(admin);
	}
	
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
	
	public void updateUser(Person person){
		Query query = em.createQuery("Select e.username from Person e");
		List<Person> username = query.getResultList();
		 String User = person.getUsername();
		if(username.contains(User)){
			for(int i =0 ; i<username.size();i++){
				Person posicao = username.get(i);
				if(User.equals(posicao.getUsername())){
					updatePerson(person);
				}
			}
		}
	}
		
	
}
