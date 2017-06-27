package personsAndAcademies.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
