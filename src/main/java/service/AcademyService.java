package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Academy;
import repository.AcademyRepository;

@Named("academyService")
@RequestScoped
public class AcademyService {
	
	@Inject
	private AcademyRepository academyRepository;
	
	
	public void createAcademy(Academy academy){
		academyRepository.createAcademy(academy);
	}
	
	public void removeAcademy(Academy academy){
		academyRepository.readAcademy();
	}
	
	public List<Academy> readAcademy(){
		return academyRepository.readAcademy();
	}
	
	public void updateAcademy(Academy academy){
		academyRepository.update(academy);
	}

	public AcademyRepository getAcademyRepository() {
		return academyRepository;
	}

	public void setAcademyRepository(AcademyRepository academyRepository) {
		this.academyRepository = academyRepository;
	}

}
