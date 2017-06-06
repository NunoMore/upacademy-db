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
	private Person favorite;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Person getFavorite() {
		return favorite;
	}

	public void setFavorite(Person favorite) {
		this.favorite = favorite;
	}

	public  String createPerson(){
		personService.createPerson(person);
		return "/Persons/MyProfileMenu";
	}
	
	public Collection<Person> readPerson(){
		return personService.readPerson();
		
	}
	
	public String updatePerson(){
		personService.updatePerson(person);
		return "index";
	}
	
	public String removePerson(){
		personService.removePerson(person);
		return "index";
	}
	public String addFavorite(){
		personService.addFavorites(person,favorite);
		return "index";
	}

}

