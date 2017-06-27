package personsAndAcademies.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class AcademyAndType extends Entities implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private String academy_name;
	private String academy_language;
	

	public String getAcademy_name() {
		return academy_name;
	}
	public void setAcademy_name(String academy_name) {
		this.academy_name = academy_name;
	}
	public String getAcademy_language() {
		return academy_language;
	}
	public void setAcademy_language(String academy_language) {
		this.academy_language = academy_language;
	}



	
}
