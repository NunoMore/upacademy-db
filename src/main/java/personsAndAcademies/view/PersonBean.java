package personsAndAcademies.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import personsAndAcademies.model.Person;

@Named("personBean")
@RequestScoped
public class PersonBean extends EntityBean<Person> {
	
	@PostConstruct
	public void init(){
		e=new Person();
	}
	
	
}

