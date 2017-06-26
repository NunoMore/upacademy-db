package personsAndAcademies.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.AcademyType;
import personsAndAcademies.repository.AcademyTypeRepository;
import personsAndAcademies.service.AcademyTypeService;

@Named("academyTypeBean")
@RequestScoped
public class AcademyTypeBean extends EntityBean<AcademyType> {
	
//	@Inject
//	private AcademyTypeService academyTypeService;
//	
//	public List<String> readAllLanguages(){
//		return academyTypeService.readLanguages();
//	}
	
	
	@PostConstruct
	public void init(){
		e=new AcademyType();
	}
	
}
