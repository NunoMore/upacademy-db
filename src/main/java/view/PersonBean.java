package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		return "/Persons/myProfileMenu";
	}
	
	public Collection<Person> readPerson(){
		return personService.readPerson();
		
	}
	
	public String updatePerson(){
		personService.updatePerson(person);
		return "/Persons/myProfileMenu";
	}
	
	public String removePerson(){
		personService.removePerson(person);
		return "index";
	}
	public String addFavorite(){
		personService.addFavorites(person,favorite);
		return "index";
	}

	private List<Person> selectedPerson;

	public List<Person> getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(List<Person> selectedPerson) {
		this.selectedPerson = selectedPerson;
	}
	
	
}

