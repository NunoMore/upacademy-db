package personsAndAcademies.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;


import personsAndAcademies.model.Academy;
import personsAndAcademies.service.AcademyService;

@Named("academyBean")
@RequestScoped
public class AcademyBean {

	private Academy academy = new Academy();
	
	private List<Academy> forEdit = new ArrayList<>();
	
	
	@Inject
	private AcademyService academyService;

	private List<Academy> editAcademy = new ArrayList<>();

	
	public void createAcademy(){
		academyService.createAcademy(academy);
		
	}
	
//	public String updateAcademy(Long ID){
//		academyService.update(ID);
//		return "readAcademies?faces-redirect=true";
//	}
	
	
	public Collection<Academy> readAcademy(){
		List<Academy> newList = academyService.readAcademy();
		return newList;
	}
	public String removeAcademyID(Long ID){

		academyService.removeAcademyID(ID);
		return "readAcademies?faces-redirect=true";
		
	}
	
	public String removeAcademy(){
		academyService.removeAcademy(academy);
		return "readAcademies?faces-redirect=true";
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

	public List<Academy> getForEdit() {
		return forEdit;
	}

	public void setForEdit(List<Academy> forEdit) {
		this.forEdit = forEdit;
	}

}
