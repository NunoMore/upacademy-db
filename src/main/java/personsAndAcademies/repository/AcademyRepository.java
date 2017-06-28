package personsAndAcademies.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import personsAndAcademies.model.Academy;


@Named("academyRepo")
@Transactional
@ApplicationScoped
public class AcademyRepository extends Repository<Academy> {
	
	
	public Academy read(Academy academy){
		Query query = em.createQuery(("Select e from Academy e where e.name = '"+ academy.getName() + "'"));
		return (Academy)query.getResultList().get(0);
	}
	
	public void remove(Academy academy){
		academy = em.find(Academy.class,academy.getID());
		em.remove(academy);
	}
	
	public Academy readByName(String academyname){
		Query query = em.createQuery(("Select e from Academy e where e.name = '"+ academyname + "'"));
		return (Academy)query.getResultList().get(0);
	}
}