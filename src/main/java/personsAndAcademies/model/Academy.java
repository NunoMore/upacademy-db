package personsAndAcademies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Academy implements Serializable {
	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue

	private String name;
	private String description;
	private String startDate;
	
	//@Lob
	//@Column(name="ACADEMY_PDF", nullable=false, columnDefinition="mediumblob")
	//private byte[] pdf;
	
	
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/*public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}*/
	public static Long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
