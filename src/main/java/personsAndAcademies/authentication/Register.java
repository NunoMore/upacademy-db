package personsAndAcademies.authentication;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import personsAndAcademies.model.User;
import personsAndAcademies.service.UserService;

@Named
@RequestScoped
public class Register {

    private User user;

    @Inject
    private UserService service;

    @PostConstruct
    public void init() {
        user = new User();
    }

    public void submit() {
        try {
            service.create(user);
            Messages.addGlobalInfo("Registration suceed, new user ID is: {0}", user.getID());
        }
        catch (RuntimeException e) {
            Messages.addGlobalError("Registration failed: {0}", e.getMessage());
            e.printStackTrace(); // TODO: logger.
        }
    }

    public User getUser() {
        return user;
    }

}