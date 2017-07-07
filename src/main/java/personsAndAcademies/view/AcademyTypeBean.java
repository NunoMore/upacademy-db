package personsAndAcademies.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import personsAndAcademies.model.AcademyType;
import personsAndAcademies.service.AcademyTypeService;

@Named("academyTypeBean")
@ViewScoped //teve de ser viewScoped para funcionar o converter !
public class AcademyTypeBean extends EntityBean<AcademyType> implements Serializable {
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init(){
		e=new AcademyType();
		list = this.readAll();
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
