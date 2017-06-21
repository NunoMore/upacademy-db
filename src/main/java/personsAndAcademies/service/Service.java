package personsAndAcademies.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import personsAndAcademies.model.Academy;
import personsAndAcademies.model.Entities;
import personsAndAcademies.model.Person;
import personsAndAcademies.repository.AcademyRepository;
import personsAndAcademies.repository.PersonRepository;
import personsAndAcademies.repository.Repository;

public abstract class Service<E extends Entities> {
	
	@Inject
	private Repository<E> repo;
	
	@Inject
	private AcademyRepository academyRepo;

	@Inject
	private PersonRepository personRepo;
	
	public void create(E e){
		repo.create(e);
	}
	
	@SuppressWarnings("unchecked")
	public E read(E e){
		if (e.getClass() == Person.class) {
			return (E)personRepo.read((Person)e);
		} else if (e.getClass() == Academy.class) {
			return (E)academyRepo.read((Academy)e);
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
		if (e.getClass() == Person.class) {
			personRepo.remove((Person)e);
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
