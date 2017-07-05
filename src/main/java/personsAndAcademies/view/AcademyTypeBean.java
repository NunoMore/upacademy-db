package personsAndAcademies.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.AcademyType;
import personsAndAcademies.service.AcademyTypeService;

@Named("academyTypeBean")
@RequestScoped
public class AcademyTypeBean extends EntityBean<AcademyType> {
	
	@PostConstruct
	public void init(){
		e=new AcademyType();
	}
	
	@Inject
	private AcademyTypeService academyTypeServ;
	
	public AcademyType read(String academyTypeName){
		return academyTypeServ.read(academyTypeName);
	}
	
	private boolean selectOther = false;
	
	public void otherTrue(){
		selectOther = true;
	}
	public void otherFalse(){
		selectOther = false;
	}

	public boolean isSelectOther() {
		return selectOther;
	}

	public void setSelectOther(boolean selectOther) {
		this.selectOther = selectOther;
	}
	

	
}
