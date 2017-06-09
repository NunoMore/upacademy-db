package repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import model.Academy;

@Named("academyRepo")
@Transactional
@ApplicationScoped
public class AcademyRepository {
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;
	
	private long academyId;
	
	private List<Academy> selectedEdit;
	
	
	public void createAcademy(Academy academy){
		em.persist(academy);
	}
	
	public void edit(Long ID){
		Academy academy = em.find(Academy.class, ID);
		em.merge(academy);
	}
	
	public List<Academy> readAcademy(){
		Query query = em.createQuery("Select e from Academy e");
		return (List<Academy>)query.getResultList();
	}
	
	public void remove(Long ID){
		System.out.println(ID);
		Academy academy = em.find(Academy.class, ID);
		em.remove(academy);
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
	
}