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
	
	private long academyId;
	
	private List<Academy> selectedEdit;
	
	public void createAcademy(Academy academy){
		em.persist(academy);
	}
	
	public List<Academy> readAcademy(){
		Query query = em.createQuery("Select e from Academy e");
		return(List<Academy>) query.getResultList();
	}
	
	
	public void updateAcademy(Academy academy){
		em.find(Academy.class, academyId).setName(academy.getName());
		em.find(Academy.class, academyId).setDate(academy.getDate());
		em.find(Academy.class, academyId).setDescription(academy.getDescription());
		
	}
	
	public void remove(Academy academy){
		em.remove(em.find(Academy.class, academy.getID()));
	}

	public long getAcademyId() {
		return academyId;
	}

	public void setAcademyId(long academyId) {
		this.academyId = academyId;
	}

	public List<Academy> getSelectedEdit() {
		return selectedEdit;
	}

	public void setSelectedEdit(List<Academy> selectedEdit) {
		this.selectedEdit = selectedEdit;
	}
	
	

	/*public void updateList(){
		List<Academy> newList= new ArrayList<>();
		for(int i=0; i<em size(); i++){
			newListadd((Academy) em.values().toArray()[i]);
			listEdit = newList;
		}
	}*/
	
}
