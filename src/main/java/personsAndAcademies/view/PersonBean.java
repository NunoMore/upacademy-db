package personsAndAcademies.view;


import java.util.Collection;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.Person;
import personsAndAcademies.service.PersonService;

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

	public void createPerson(){
		personService.createPerson(person);
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
	public String removePersonId(long ID){
		personService.removePersonId(ID);
		return "index";
	}
}

