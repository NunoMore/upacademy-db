package personsAndAcademies.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import personsAndAcademies.model.Academy;

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
	
	public void edit(Academy academy){
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
	
	public void update(Academy academy){
		
		String currentAcademy = academy.getName();
		
		Query query = em.createQuery(("Select e from Academy e where e.name = '"+ currentAcademy + "'"));
		
		Academy academyUpdate  = (Academy) query.getSingleResult();
		
		academyUpdate.setName(academy.getName());
		academyUpdate.setDate(academy.getDate());
		academyUpdate.setDescription(academy.getDescription());

		edit(academyUpdate);
		
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