package view;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import model.Person;
import service.PersonService;

@Named("personBean")
@RequestScoped
public class PersonBean {

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
		return "index";
	}
	
	public Collection<Person> readPerson(){
		return personService.readPerson();
		
	}
	
//	public String updatePerson(){
//		personService.updatePerson(person);
//		return "index";
//	}
	
	public String removePerson(){
		personService.removePerson(person);
		return "index";
	}
}
