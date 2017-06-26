package personsAndAcademies.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import personsAndAcademies.model.AcademyType;

@Named("academyTypeBean")
@RequestScoped
public class AcademyTypeBean extends EntityBean<AcademyType> {
	
	@PostConstruct
	public void init(){
		e=new AcademyType();
	}

}
