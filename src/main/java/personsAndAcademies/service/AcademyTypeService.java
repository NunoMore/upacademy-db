package personsAndAcademies.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.AcademyType;
import personsAndAcademies.repository.AcademyTypeRepository;

@Named("academyTypeService")
@RequestScoped
public class AcademyTypeService extends Service<AcademyType>{
	
	@Inject
	private AcademyTypeRepository academyTyperepo;
	
	public List<String> allLanguages(){
		return academyTyperepo.readLanguages();
	}
	
//	String [] arrayLanguages = new String [allLanguages().size()];
	
}
