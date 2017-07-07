package personsAndAcademies.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import personsAndAcademies.model.Academy;

@Named("academyBean")
@ViewScoped
public class AcademyBean extends EntityBean<Academy> implements Serializable {
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init(){
		e=new Academy();
		list = readAll();
	}
	
	

}
