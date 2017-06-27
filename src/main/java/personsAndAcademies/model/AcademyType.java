package personsAndAcademies.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class AcademyType extends Entities implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String language;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}


	@Override
	public String toString(){
		return "" + language+ ""; 
	}

}
