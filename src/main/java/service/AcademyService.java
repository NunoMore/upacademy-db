package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.Academy;

@Named("academyService")
@Transactional
@RequestScoped
public class AcademyService {
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;
	
	//private List<Academy> listEdit = new ArrayList<>();
	//private List<Academy> selectedEdit;
	
	
	
	public void createAcademy(Academy academy){
		em.persist(academy);
	}
	
	public List<Academy> readAcademy(){
		Query query = em.createQuery("Select e from Academy e");
		return(List<Academy>) query.getResultList();
	}
	
	public void removeAcademy (Academy academy){
		academy = em.find(Academy.class, academy.getName());
		em.remove(academy);
	}
	
	/*public void updateList(){
		List<Academy> newList= new ArrayList<>();
		for(int i=0; i<em size(); i++){
			newListadd((Academy) em.values().toArray()[i]);
			listEdit = newList;
		}
	}*/
	
}
