package personsAndAcademies.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.Query;

import personsAndAcademies.model.User;

@Named("userRepo")
@ApplicationScoped
public class UserRepository extends Repository<User>{
	

	@SuppressWarnings("unchecked")
	public List<String> readPhotos(){
		Query query = em.createQuery("Select photo from User");
		return (List<String>) query.getResultList();
	}
	
	public User find(Long id) {
        return em.find(User.class, id);
    }
	
	public User find(String username, String password) {
        List<User> found = em.createNamedQuery("User.find", User.class)
            .setParameter("username", username)
            .setParameter("password", password)
            .getResultList();
        return found.isEmpty() ? null : found.get(0);
    }
	
	public User read(User user){
		Query query = em.createQuery(("Select e from User e where e.username = '"+ user.getUsername() + "'"));
		return (User)query.getResultList().get(0);
	}
	public void remove(User user){
		user = em.find(User.class,user.getID());
		em.remove(user);
	}
	
	public void delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }
	
	 @Produces
	    @Named("users")
	    @RequestScoped
	    public List<User> list() {
	        return em.createNamedQuery("User.list", User.class).getResultList();
	    }
}
