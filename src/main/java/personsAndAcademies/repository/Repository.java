package personsAndAcademies.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import personsAndAcademies.model.Entities;


@Transactional
public abstract class Repository <E extends Entities> {
	
// devemos usar enum?
//	private enum type{
//		PERSON,
//		ACADEMY,
//		ACADEMYTYPE,
//		PROJECTS
//	}
	
	@PersistenceContext(name="ProjectDataBase")
	protected EntityManager em;
	
	public void create(E e){
		em.persist(e);
	}
		
	@SuppressWarnings("unchecked")
	public List<E> readAll(String entity){
		Query query = em.createQuery("Select e from "+ entity + " e");
		return (List<E>) query.getResultList();
	}
	
	public void update(E e){
		em.merge(e);
	}

}
