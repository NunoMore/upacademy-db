package personsAndAcademies.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.Academy;
import personsAndAcademies.repository.AcademyRepository;

@Named("academyService")
@RequestScoped
public class AcademyService extends Service<Academy> {
	
	@Inject
	private AcademyRepository academyRepo;

	public Academy readName(String academyname){
		return academyRepo.readByName(academyname);
	}

}
