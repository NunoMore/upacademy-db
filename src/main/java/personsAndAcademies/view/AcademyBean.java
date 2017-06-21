package personsAndAcademies.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import personsAndAcademies.model.Academy;

@Named("academyBean")
@RequestScoped
public class AcademyBean extends EntityBean<Academy> {
	
	@PostConstruct
	public void init(){
		e=new Academy();
	}

}
