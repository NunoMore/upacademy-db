package personsAndAcademies.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import personsAndAcademies.model.Academy;


@Named("academyRepo")
@ApplicationScoped
public class AcademyRepository extends Repository<Academy> {
	
	public Academy read(Academy academy){
		TypedQuery<Academy> query = em.createQuery("Select e from Academy e where e.name = '"+ academy.getName() + "'", Academy.class);
		return query.getResultList().get(0);
	}
	public Academy read(String academyname){
		TypedQuery<Academy> query = em.createQuery("Select e from Academy e where e.name = '"+ academyname + "'", Academy.class);
		return query.getResultList().get(0);
	}
	
	public void remove(Academy academy){
		academy = em.find(Academy.class,academy.getID());
		em.remove(academy);
	}
	
}