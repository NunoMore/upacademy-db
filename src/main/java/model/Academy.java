package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@Entity
public class Academy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue

	private String name;
	private String description;
	private Date date;
	
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
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	
	// Metodo para o selecionar data de inicio da academia no menu create academy
	public void onDateSelect(SelectEvent event){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}
	
	public void click(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		
		requestContext.update("form:display");
		requestContext.execute("PF('dlg').show()");
	}

	
}
