package personsAndAcademies.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("messagesView")
@SessionScoped
public class MessagesView {
	
	public void info(String str) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", str));
    }

}
