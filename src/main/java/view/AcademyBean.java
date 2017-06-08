package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Academy;
import model.Person;
import service.AcademyService;

@Named("academyBean")
@RequestScoped
public class AcademyBean {

	private Academy academy = new Academy();
	@Inject
	private AcademyService academyService;
	
	
	private List<Academy> editAcademy = new ArrayList<>();
	
	public String createAcademy(){
		academyService.createAcademy(academy);
		return "AcademyMenu";
	}
	
	public Collection<Academy> readAcademy(){
		return academyService.readAcademy();
		
	}
	public String removeAcademy(List<Academy> editAcademy, String nextPage){
		academyService.removeAcademy(academy);
		academyService.updateAcademy(academy);
		return nextPage;
		
	}
	
	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	public AcademyService getAcademyService() {
		return academyService;
	}

	public void setAcademyService(AcademyService academyService) {
		this.academyService = academyService;
	}

	public List<Academy> getEditAcademy() {
		return editAcademy;
	}

	public void setEditAcademy(List<Academy> editAcademy) {
		this.editAcademy = editAcademy;
	}

	
	
}
