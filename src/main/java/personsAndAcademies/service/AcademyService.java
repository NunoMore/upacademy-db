package personsAndAcademies.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import personsAndAcademies.model.Academy;
import personsAndAcademies.repository.AcademyRepository;

@Named("academyService")
@RequestScoped
@Transactional
public class AcademyService extends Service<Academy> {
	
	@Inject
	private AcademyRepository academyRepo;

	public Academy read(String academyname){
		return academyRepo.read(academyname);
	}

}
