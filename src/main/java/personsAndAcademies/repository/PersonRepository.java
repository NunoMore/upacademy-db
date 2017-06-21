package personsAndAcademies.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import personsAndAcademies.model.Person;

@Named("personRepo")
@Transactional
@ApplicationScoped
public class PersonRepository extends Repository<Person>{
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;
	
	@PostConstruct
	public void initAdmim(){
		final Person admin = new Person();
		admin.setName("Admin");
		admin.setPassword("admin");
		admin.setUsername("admin");
		create(admin);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> readPhotos(){
		Query query = em.createQuery("Select photo from Person");
		return (List<String>) query.getResultList();
	}
	
	public Person read(Person person){
		Query query = em.createQuery(("Select e from Person e where e.username = '"+ person.getUsername() + "'"));
		return (Person)query.getResultList().get(0);
	}
	public void remove(Person person){
		person = em.find(Person.class,person.getID());
		em.remove(person);
	}
}
