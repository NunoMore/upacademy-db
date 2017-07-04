
package personsAndAcademies.service;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import personsAndAcademies.model.User;
import personsAndAcademies.repository.UserRepository;

@Named("userService")
@RequestScoped
@Transactional
public class UserService extends Service<User> {
	
	@Inject
	private UserRepository userRepository;
	
	public List<String> readPhotos(){
		return userRepository.readPhotos();
	}
}

