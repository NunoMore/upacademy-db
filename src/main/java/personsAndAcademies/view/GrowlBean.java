package personsAndAcademies.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
public class GrowlBean {
	
	private String message = null;
	private String details = null;
	
	public void defineGrowl(String message, String details, String forString){
		FacesMessage growl = new FacesMessage(message, details);
		FacesContext.getCurrentInstance().addMessage(forString, growl);	
	}
//	public void defineGrowl(String message, String details){
//		FacesMessage growl = new FacesMessage(message, details);
//		FacesContext.getCurrentInstance().addMessage(null, growl);	
//	}
//	public void defineGrowl(String message){
//		FacesMessage growl = new FacesMessage(message, details);
//		FacesContext.getCurrentInstance().addMessage(null, growl);	
//	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
