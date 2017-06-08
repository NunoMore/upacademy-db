package view;


import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import model.Person;
import service.PersonService;

@Named("personBean")
@RequestScoped
public class PersonBean {
	
	@PostConstruct
	public void initAdmim(){
		final Person admin = new Person();
		admin.setPassword("admin");
		admin.setUsername("admin");
		
		
	}
	
	
	private Person person = new Person();
	@Inject
	private PersonService personService;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public  String createPerson(){
		personService.createPerson(person);
		return "myProfileMenu";
	}
	
	public Collection<Person> readPerson(){
		return personService.readPerson();
		
	}
	
	public String updatePerson(){
		personService.updatePerson(person);
		return "myProfileMenu";
	}
	
	public String removePerson(){
		personService.removePerson(person);
		return "index";
	}
}

