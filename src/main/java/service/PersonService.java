package service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named("personService")
@Transactional
@RequestScoped
public class PersonService {
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;

}
