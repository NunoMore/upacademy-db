package personsAndAcademies.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import personsAndAcademies.model.AcademyType;

@Named("academyTypeRepo")
@ApplicationScoped
public class AcademyTypeRepository extends Repository<AcademyType>{
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;
	
	public AcademyType read(AcademyType academyType){
		TypedQuery<AcademyType> query = em.createQuery("Select e from AcademyType e where e.language = '"+ academyType.getLanguage() + "'", AcademyType.class);
		return query.getResultList().get(0);
	}
	public AcademyType read(String academyTypeName){
		TypedQuery<AcademyType> query = em.createQuery("Select e from AcademyType e where e.language = '"+ academyTypeName + "'", AcademyType.class);
		return query.getResultList().get(0);
	}
	
	public void remove(AcademyType academyType){
		academyType = em.find(AcademyType.class,academyType.getID());
		em.remove(academyType);
	}

	
}
