package personsAndAcademies.view;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;

import personsAndAcademies.model.Person;

@Named("currentUserBean")
@SessionScoped
public class CurrentUserBean extends EntityBean<Person> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private File tempFolder;
		
		@PostConstruct
		public void createFolder() throws IOException{
			e=new Person();
			try { // mudar pasta de destino
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
