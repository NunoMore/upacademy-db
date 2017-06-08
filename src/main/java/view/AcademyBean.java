package view;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Academy;
import service.AcademyService;

@Named("academyBean")
@RequestScoped
public class AcademyBean {

	private Academy academy = new Academy();
	@Inject
	private AcademyService academyService;
	
	public String createAcademy(){
		academyService.createAcademy(academy);
		return "/Academy/AcademyMenu";
	}
	
	public Collection<Academy> readAcademy(){
		return academyService.readAcademy();
		
	}
	
	public void removeAcademy(){
		academyService.removeAcademy(academy);
	}

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
	
	
}
