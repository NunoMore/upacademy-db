package personsAndAcademies.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class AcademyType extends Entities implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String language;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name = "name")
	private List<Academy> names;
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<Academy> getNames() {
		return names;
	}
	public void setNames(List<Academy> names) {
		this.names = names;
	}


	@Override
	public String toString(){
		return "" + language+ ""; 
	}

	
}
