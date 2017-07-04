package personsAndAcademies.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Academy extends Entities implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Date date;
	private String pdf;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACADEMY_TYPE_ID")
	private AcademyType programmingLanguage;

	@OneToMany(mappedBy = "academy")
	private List<User> users;
	
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
	public AcademyType getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(AcademyType programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	@Override
	public String toString(){
		return name; 
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
