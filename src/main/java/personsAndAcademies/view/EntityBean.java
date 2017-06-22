package personsAndAcademies.view;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import personsAndAcademies.model.Academy;
import personsAndAcademies.model.Entities;
import personsAndAcademies.model.Person;
import personsAndAcademies.service.Service;

@Transactional
public class EntityBean<E extends Entities> {
	
	protected E e;
	
	@Inject
	private Service<E> service;	
	
	public void create(){
		service.create(e);
	}
	
	public E read(){
		return service.read(e);
	}
	
	public List<E> readAll(){
		if (e.getClass() == Person.class) {
			return service.readAll("Person");
		} else if (e.getClass() == Academy.class) {
			return service.readAll("Academy");
		}
		return null;
	}
	
	public void update(){
		service.update(e);
	}
	
	public void remove(){
		service.remove(e);
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}

}
