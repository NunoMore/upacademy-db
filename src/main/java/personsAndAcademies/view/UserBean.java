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
//	@Inject
//	private AcademyService acadServ;
	
//	@Override
//	public List<User> readAll(){
//
//		List<User> list = service.readAll("User");
//		for (int i=0; i<list.size();i++) {
//			list.get(i).setLanguageProgramming(acadServ.readName(list.get(i).getAcademy()).getProgrammingLanguage());
//		}
//		
//		return list;
//		
//	}
	
	
}
