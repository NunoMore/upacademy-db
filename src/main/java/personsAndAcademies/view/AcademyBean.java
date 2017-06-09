package personsAndAcademies.view;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.Academy;
import personsAndAcademies.service.AcademyService;

@Named("academyBean")
@RequestScoped
public class AcademyBean {

	private Academy academy = new Academy();
	@Inject
	private AcademyService academyService;
	
	public String createAcademy(String nextPage){
		academyService.createAcademy(academy);
		return nextPage;
	}
	
	public Collection<Academy> readAcademy(){
		return academyService.readAcademy();
		
	}
	
	public void removeAcademy(){
		academyService.removeAcademy(academy);
	}
	
	
}
