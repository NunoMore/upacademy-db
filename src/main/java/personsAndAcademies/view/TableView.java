package personsAndAcademies.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import personsAndAcademies.model.Academy;
import personsAndAcademies.model.AcademyType;
import personsAndAcademies.model.Person;

@Named("tableView")
@SessionScoped
public class TableView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Person selectedPerson; //atributo para guardar person que sera selecionada na tabela do main
	private List<Person> filteredPersons; //atributo para guardar a seleccao de filtragem
	
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


	
	public String fillSelectedPerson(Person person){
		selectedPerson = person;
		return "/Persons/ProfileMenu?faces-redirect=true";
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
