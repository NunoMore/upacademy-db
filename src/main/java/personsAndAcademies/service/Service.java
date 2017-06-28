package personsAndAcademies.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import personsAndAcademies.model.Academy;
import personsAndAcademies.model.AcademyType;
import personsAndAcademies.model.Entities;
import personsAndAcademies.model.User;
import personsAndAcademies.repository.AcademyRepository;
import personsAndAcademies.repository.AcademyTypeRepository;
import personsAndAcademies.repository.Repository;
import personsAndAcademies.repository.UserRepository;

public abstract class Service<E extends Entities> {
	
	@Inject
	private Repository<E> repo;
	
	@Inject
	private AcademyRepository academyRepo;
	
	@Inject
	private AcademyTypeRepository academyTypeRepo;

	@Inject
	private UserRepository userRepo;
	
	public void create(E e){
		repo.create(e);
	}
	
	@SuppressWarnings("unchecked")
	public E read(E e){
		if (e.getClass() == User.class) {
			return (E)userRepo.read((User)e);
		} else if (e.getClass() == Academy.class) {
			return (E)academyRepo.read((Academy)e);
		}
		else if (e.getClass() == AcademyType.class) {
			return (E)academyTypeRepo.read((AcademyType)e);
		}
		return null;
	}
	
	public List<E> readAll(String entity){
		return repo.readAll(entity); 
	}
	
	public void update(E e){
		repo.update(e);
	}
	
	public void remove(E e){
		if (e.getClass() == User.class) {
			userRepo.remove((User)e);
		} else if (e.getClass() == Academy.class) {
			academyRepo.remove((Academy)e);
		}
	}

	// Metodo para tratar formato de data
	public void onDateSelect(SelectEvent event){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

}
