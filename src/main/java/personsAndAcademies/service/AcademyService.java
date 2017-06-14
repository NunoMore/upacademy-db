package personsAndAcademies.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

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
	
	public void update(Academy academy){
		academyRepository.edit(academy);
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
	
	// Metodo para o selecionar data de inicio da academia no menu create academy
	public void onDateSelect(SelectEvent event){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

}
