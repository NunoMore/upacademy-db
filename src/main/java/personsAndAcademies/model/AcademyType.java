package personsAndAcademies.model;

import java.io.Serializable;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.JoinTable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;

@Entity
public class AcademyType extends Entities implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String language;
	private String other;
//	private Set<Academy> academies;
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
//	public Set<Academy> getAcademies() {
//		return academies;
//	}
//	public void setAcademies(Set<Academy> academies) {
//		this.academies = academies;
//	}
	
	
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "academyandtype", joinColumns = @JoinColumn(name = "academytype_language", referencedColumnName = "language"), inverseJoinColumns = @JoinColumn(name = "academy_name", referencedColumnName = "name"))
//    public Set<Academy> geAcademies() {
//        return academies;
//    }
	
	

	
}
