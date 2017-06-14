package personsAndAcademies.view;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.Person;
import personsAndAcademies.service.PersonService;

import java.io.Serializable;

@Named("currentUserBean")
@SessionScoped
public class CurrentUserBean implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Person person = new Person();
		
		@Inject
		private PersonService personService;
		private Boolean editMode = true;
		private String editState;
		
		@PreDestroy
		public void logOut(){
			person.setOnline(false); 
		}
	
		public void initCurrentUser(){
			person = personService.readPerson(person.getUsername());
			person.setOnline(true);
			personService.updatePerson(person);
		}

		public Person getPerson() {
			return person;
		}

		public void setPerson(Person person) {
			this.person = person;
		}

		
		public String getEditMode() {
			return editMode.toString();
		}

		public void setEditMode(boolean editMode) {
			this.editMode = editMode;
		}

		public String getEditState() {
			return editState;
		}

		public void setEditState(String editState) {
			this.editState = editState;
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
		public String updateUser(){
			personService.updateUser(person);
			return "myProfileMenu";
		}
		public boolean changeEditMode(){
			if(editMode==true){
				editState="Modo Editar ativado";
				return editMode=false;
			}else{
				editState="Modo Editar ativado";

				return editMode=true;
			}
		}
	}
