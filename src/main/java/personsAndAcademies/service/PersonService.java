
package personsAndAcademies.service;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.Person;
import personsAndAcademies.repository.PersonRepository;

@Named("personService")
@RequestScoped
public class PersonService extends Service<Person> {
	
	@Inject
	private PersonRepository personRepository;
	
	public List<String> readPhotos(){
		return personRepository.readPhotos();
	}
}

