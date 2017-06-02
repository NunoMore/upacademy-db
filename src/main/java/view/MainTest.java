package view;

import model.Person;
import service.PersonService;


public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		
		person.setName("Andre");
		
		String oi = PersonBean.createPerson(person);
	}

}
