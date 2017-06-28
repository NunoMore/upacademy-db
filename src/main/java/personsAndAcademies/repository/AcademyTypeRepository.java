package personsAndAcademies.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import personsAndAcademies.model.AcademyType;

@Named("academyTypeRepo")
@Transactional
@ApplicationScoped
public class AcademyTypeRepository extends Repository<AcademyType>{
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;
	
	public AcademyType read(AcademyType academyType){
		Query query = em.createQuery(("Select e from AcademyType e where e.language = '"+ academyType.getLanguage() + "'"));
		return (AcademyType)query.getResultList().get(0);
	}
	
	public void remove(AcademyType academyType){
		academyType = em.find(AcademyType.class,academyType.getID());
		em.remove(academyType);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<String> readLanguages(){
		Query query = em.createQuery("Select language from AcademyType language");
		return (List<String>) query.getResultList();
		
	}
	
}
	

