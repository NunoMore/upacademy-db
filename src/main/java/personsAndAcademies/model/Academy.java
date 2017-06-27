package personsAndAcademies.model;

import personsAndAcademies.model.AcademyType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;


@Entity
public class Academy extends Entities implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Date date;
	private String programmingLanguage;
	
	
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

}
