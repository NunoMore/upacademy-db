package personsAndAcademies.model;

import java.io.Serializable;
import java.util.Date;
//import java.util.Set;

import javax.persistence.Entity;
//import javax.persistence.ManyToMany;

@Entity
public class Academy extends Entities implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Date date;
	private String programmingLanguage;
//	private Set<AcademyType> types;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
//	public Set<AcademyType> getTypes() {
//		return types;
//	}
//	public void setTypes(Set<AcademyType> types) {
//		this.types = types;
//	}	
//	
//	  @ManyToMany(mappedBy = "academies")
//	    public Set<AcademyType> geTypes() {
//	        return types;
//	    }
}
