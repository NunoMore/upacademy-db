package personsAndAcademies.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;


import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import personsAndAcademies.model.Academy;
import personsAndAcademies.model.Person;

@Named("academyRepo")
@Transactional
@ApplicationScoped
public class AcademyRepository {
	
	
	
	@PersistenceContext(name="ProjectDataBase")
	private EntityManager em;
	
	private Academy academy;
	
	private long academyId;
	
	private List<Academy> selectedEdit;
	
	private ArrayList<Academy> removedList = new ArrayList<>();
	

	public void createAcademy(Academy academy){
		em.persist(academy);
	}
	
	public void edit(Long ID){
		em.merge(ID);
	}
	
	public List<Academy> readAcademy(){
		Query query = em.createQuery("Select e from Academy e");
		return (List<Academy>)query.getResultList();
	}
	
	public void remove(Long ID){
		System.out.println(ID);
		Academy academy = em.find(Academy.class, ID);
		em.remove(academy);
	}
	

	public void update(Long ID){
		
		Academy academy = em.find(Academy.class, ID);
				
		academy.setName(academy.getName());
		academy.setDate(academy.getDate());
		academy.setDescription(academy.getDescription());

		edit(ID);
		
	}
	
	public long getAcademyId() {
		return academyId;
	}

	public void setAcademyId(long academyId) {
		this.academyId = academyId;
	}

	public List<Academy> getSelectedEdit() {
		return selectedEdit;
	}

	public void setSelectedEdit(List<Academy> selectedEdit) {
		this.selectedEdit = selectedEdit;
	}
	
	
	public void lastUpdate(){
		Academy academy = new Academy();
		
		Query query = em.createQuery("Select e from Academy e");
		
		Academy updateList = (Academy) query.getSingleResult();
		
		updateList.setID(academy.getID());
		updateList.setName(academy.getName());
		updateList.setDate(academy.getDate());
		updateList.setDescription(academy.getDescription());
		
		
		//em.getTransaction().begin();
		em.merge(updateList);
		//em.getTransaction().commit();
		
	}
	
	  public void editCell(CellEditEvent event) {
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();
	         
	        if(newValue != null && !newValue.equals(oldValue)) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}


	
	
	/*public void editable(){
		
		long IDacademy;
		List<Academy> st = readAcademy();
		FacesContext fc=FacesContext.getCurrentInstance();
	//	Map<String, String> mapParam = fc.getExternalContext().getInitParameterMap();
	//	IDacademy= mapParam.get("ID");
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		IDacademy= Long.parseLong(request.getParameter("ID"));
		
		for(Academy academy : st){
			
			if(academy.getID() == IDacademy){
				
				this.academy.setID(academy.getID());
				this.academy.setName(academy.getName());
				this.academy.setDate(academy.getDate());
				this.academy.setDescription(academy.getDescription());
			}
		}
		
		
		
		
	}*/

	
	
}