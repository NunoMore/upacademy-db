package personsAndAcademies.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FileUtils;

import personsAndAcademies.model.Person;
import personsAndAcademies.service.PersonService;

@Named("currentUserBean")
@SessionScoped
public class CurrentUserBean implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Person person = new Person();
		private File tempFolder;
		
		@Inject
		private PersonService personService;
		private Boolean editMode = true;
		private String editState;
		
		@PostConstruct
		public void createFolder() throws IOException{
			try {
				String filename = "Uploads"; //nao mudar este nome!!!!!!!!!!!
				String workingDirectory = System.getProperty("jboss.server.data.dir"); //vai buscar directory mas com um extra "/data"
				workingDirectory = workingDirectory.replace(File.separator+"data", ""); //elimina "/data" - substitui por vazio
				String absolutPath = workingDirectory + File.separator + "deployments"+ File.separator + "UPACADEMY_DB.war"+ File.separator + "resources" + File.separator + filename; //ATENCAO!!!!!!! perguntar ao luis se isto vai funcionaar XD
				tempFolder = new File(absolutPath);
				tempFolder.mkdir();
				
//				uploadPhotos();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		@PreDestroy
		public void logOut() throws IOException{
			person.setOnline(false);
			this.updateUser();
//			FileUtils.cleanDirectory(tempFolder);
		}
	
		public void initCurrentUser(){
			if(!person.getUsername().isEmpty()){
				person = personService.readPerson(person.getUsername());
				person.setOnline(true);
				personService.updatePerson(person);
			}
		}

		public Person getPerson() {
			return person;
		}

		public void setPerson(Person person) {
			this.person = person;
		}

		
		public String getEditMode() {
			return editMode.toString();
		}

		public void setEditMode(boolean editMode) {
			this.editMode = editMode;
		}

		public String getEditState() {
			return editState;
		}

		public void setEditState(String editState) {
			this.editState = editState;
		}

		public  String createPerson(){
			personService.createPerson(person);
			return "myProfileMenu";
		}
		
		public Collection<Person> readPerson(){
			return personService.readPerson();
			
		}
		
		public String updatePerson(){
			personService.updatePerson(person);
			return "myProfileMenu";
		}
		
		public String removePerson(){
			personService.removePerson(person);
			return "index";
		}
		public String updateUser() throws IOException{
			personService.updateUser(person);
			return "myProfileMenu";
		}
		public boolean changeEditMode(){
			if(editMode==true){
				editState="Modo Editar ativado";
				return editMode=false;
			}else{
				editState="Modo Editar ativado";

				return editMode=true;
			}
		}
		
//		private void uploadPhotos() throws IOException{ //nao testado
//			
//			List<String> photosList = personService.readPhotos();
//			for (int i = 0; i < photosList.size(); i++) {
//				String photo = photosList.get(i);
//				File file = new File(tempFolder, photo);
//				BufferedImage img = ImageIO.read(file);
//				String extension = photo.substring(photo.length() - 4);
//				ImageIO.write(img, extension, file);
//			}
//		}

		public File getTempFolder() {
			return tempFolder;
		}

		public void setTempFolder(File tempFolder) {
			this.tempFolder = tempFolder;
		}
		
	}
