package personsAndAcademies.view;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import personsAndAcademies.model.Academy;
import personsAndAcademies.model.AcademyType;
import personsAndAcademies.model.Entities;
import personsAndAcademies.model.Person;
import personsAndAcademies.service.Service;

@Transactional
public class EntityBean<E extends Entities> extends GrowlBean{
	
	protected E e;
	
	@Inject
	private Service<E> service;	
	
	public void create(){
		service.create(e);
		defineGrowl("Success!", "Entity was created!", "create");
	}
	
	public E read(){
		return service.read(e);
	}
	
	public List<E> readAll(){
		if (e.getClass() == Person.class) {
			return service.readAll("Person");
		} else if (e.getClass() == Academy.class) {
			return service.readAll("Academy");
		}else if (e.getClass() == AcademyType.class) {
			return service.readAll("AcademyType");
		}
		return null;
	}
	
	public void update(){
		service.update(e);
		defineGrowl("Success!", "Entity was updated!", "update");
	}
	
	public void remove(){
		service.remove(e);
		defineGrowl("Success!", "Entity was removed!", "remove");
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}

}
