package personsAndAcademies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AcademyType extends Entities implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String language;
	
	@OneToMany(mappedBy = "programmingLanguage")
	private List<Academy> academies;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public List<Academy> getAcademies() {
		return academies;
	}
	public void setAcademies(List<Academy> academies) {
		this.academies = academies;
	}


	@Override
	public String toString(){
		return language; 
	}

}
