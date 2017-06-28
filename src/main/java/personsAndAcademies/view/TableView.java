package personsAndAcademies.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import personsAndAcademies.model.Academy;
import personsAndAcademies.model.AcademyType;
import personsAndAcademies.model.User;

@Named("tableView")
@SessionScoped
public class TableView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private User selectedUser = new User(); //atributo para guardar person que sera selecionada na tabela do main
	private List<User> filteredUsers; //atributo para guardar a seleccao de filtragem
	
	private Academy selectedAcademy = new Academy();
	private List<Academy> filteredAcademies;
	
	private AcademyType selectedType;
	private List<AcademyType> filteredTypes;
	
	public AcademyType getSelectedType() {
		return selectedType;
	}

	public void setSelectedType(AcademyType selectedType) {
		this.selectedType = selectedType;
	}

	public List<AcademyType> getFilteredTypes() {
		return filteredTypes;
	}

	public void setFilteredTypes(List<AcademyType> filteredTypes) {
		this.filteredTypes = filteredTypes;
	}


	
	public String fillSelectedUser(User user){
		selectedUser = user;
		return "/Persons/ProfileMenu?faces-redirect=true";
	}

	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<Academy> getFilteredAcademies() {
		return filteredAcademies;
	}

	public void setFilteredAcademies(List<Academy> filteredAcademies) {
		this.filteredAcademies = filteredAcademies;
	}

	public Academy getSelectedAcademy() {
		return selectedAcademy;
	}

	public void setSelectedAcademy(Academy selectedAcademy) {
		this.selectedAcademy = selectedAcademy;
	}


}
