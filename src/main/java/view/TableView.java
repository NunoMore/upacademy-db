package view;

import java.io.Serializable;
import java.rmi.activation.ActivationDesc;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Person;

@Named("tableView")
@SessionScoped
public class TableView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Person selectedPerson; //atributo para guardar person que sera selecionada na tabela do main
	private List<Person> filteredPersons; //atributo para guardar a seleccao de filtragem

	private static String[] academies; //lista de academias
	
	static{
		academies = new String[2];
		academies[0] = "Java";
		academies[1] = "OutSystems";
	}
	
	public void setAcademies(String[] academies) {
		TableView.academies = academies;
	}

	public String[] getAcademies() {
		return academies;
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
}
