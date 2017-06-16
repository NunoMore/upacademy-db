
package personsAndAcademies.service;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.event.SelectEvent;

import personsAndAcademies.model.Person;
import personsAndAcademies.repository.PersonRepository;

@Named("personService")
@Transactional
@RequestScoped
public class PersonService {
	
	
	@Inject
	private PersonRepository personRepository;
	
	public void createPerson(Person person){
		personRepository.createPerson(person);
	}
	public List<Person> readPerson(){
		return personRepository.readPerson();
	}
	public Person readPerson(String user){
		return personRepository.readPerson(user);
	}
	public void updatePerson(Person person){
		personRepository.updatePerson(person);
	}
	public void removePerson(Person person){
		personRepository.removePerson(person);
	}
	
	public void updateUser(Person person) throws IOException{
		personRepository.updateUser(person);
	}
	public void removePersonId(long ID){
		personRepository.removePersonId(ID);
	}
	
	// Metodo para o selecionar data de inicio da academia no menu create academy
	public void onDateSelect(SelectEvent event){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}
}

