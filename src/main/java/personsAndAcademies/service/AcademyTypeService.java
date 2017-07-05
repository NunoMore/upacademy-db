package personsAndAcademies.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import personsAndAcademies.model.AcademyType;
import personsAndAcademies.repository.AcademyTypeRepository;

@Named("academyTypeService")
@RequestScoped
@Transactional
public class AcademyTypeService extends Service<AcademyType>{
	
	@Inject
	private AcademyTypeRepository academyTypeRepo;
	
	public AcademyType read(String academyTypeName){
		return academyTypeRepo.read(academyTypeName);
	}
	
}
