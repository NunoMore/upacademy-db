package personsAndAcademies.repository;

import java.io.IOException;
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
public class PersonRepository {
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;
	
	@PostConstruct
	public void initAdmim(){
		final Person admin = new Person();
		admin.setName("Admin");
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
	public Person readPerson(String user){
		Query query = em.createQuery(("Select e from Person e where e.username = '"+ user + "'"));
		return (Person)query.getResultList().get(0);
	}
	public void updatePerson(Person person){
		em.merge(person);
	}
	public void removePerson(Person person){
		person = em.find(Person.class,person.getID());
		em.remove(person);
	}
	
	public void updateUser(Person person) throws IOException{
		String User = person.getUsername();
		
		Query query = em.createQuery(("Select e from Person e where e.username = '"+ User + "'"));

		
			Person userNameList = (Person) query.getSingleResult();
			
			userNameList.setName(person.getName());
			userNameList.setAcademicCourse(person.getAcademicCourse());
			userNameList.setAcademy(person.getAcademy());
			userNameList.setNumTelephone(person.getNumTelephone());
			userNameList.setEmail(person.getEmail());
			userNameList.setFacebookLink(person.getFacebookLink());
			userNameList.setLinkedInLink(person.getLinkedInLink());
			userNameList.setGitHubLink(person.getGitHubLink());
			userNameList.setWorkPlace(person.getWorkPlace());
			userNameList.setCurriculum(person.getCurriculum());
			userNameList.setDateOfBirth(person.getDateOfBirth());
			userNameList.setGender(person.getGender());
			userNameList.setPhoto(person.getPhoto());


			updatePerson(userNameList);

	}
	public void removePersonId(Long ID){
		Person person = em.find(Person.class,ID);
		em.remove(person);
	}
	
}
