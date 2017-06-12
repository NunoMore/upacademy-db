package personsAndAcademies.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.Academy;
import personsAndAcademies.repository.AcademyRepository;

@Named("academyService")
@RequestScoped
public class AcademyService {
	
	@Inject
	private AcademyRepository academyRepository;
	
	
	public void createAcademy(Academy academy){
		academyRepository.createAcademy(academy);
	}
	
	public void editAcademy(Long ID){
		academyRepository.edit(ID);
	}
	
	public void removeAcademy(Long ID){
		academyRepository.remove(ID);
	}
	
	public List<Academy> readAcademy(){
		return academyRepository.readAcademy();
	}


	public AcademyRepository getAcademyRepository() {
		return academyRepository;
	}

	public void setAcademyRepository(AcademyRepository academyRepository) {
		this.academyRepository = academyRepository;
	}

}
