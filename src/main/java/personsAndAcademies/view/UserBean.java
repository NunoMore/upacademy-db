package personsAndAcademies.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import personsAndAcademies.model.User;
@Named("userBean")
@RequestScoped
public class UserBean extends EntityBean<User>{

	@PostConstruct
	public void init(){
		e=new User();
	}
}
