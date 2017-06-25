package personsAndAcademies.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import personsAndAcademies.model.Academy;
import personsAndAcademies.model.Person;

@Named("tableView")
@SessionScoped
public class TableView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Person selectedPerson; //atributo para guardar person que sera selecionada na tabela do main
	private List<Person> filteredPersons; //atributo para guardar a seleccao de filtragem
	
	private Academy selectedAcademy;
	private List<Academy> filteredAcademies; 
	
	@Inject
	private CurrentUserBean currentUser;
	
	public void erase(){
		selectedPerson = new Person();
		selectedAcademy = new Academy();
	}

	public List<Person> getFilteredPersons() {
		return filteredPersons;
	}

	public void setFilteredPersons(List<Person> filteredPersons) {
		this.filteredPersons = filteredPersons;
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
		if (selectedPerson.getUsername() == currentUser.getE().getUsername()) {
			currentUser.setE(selectedPerson); 
		}
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
