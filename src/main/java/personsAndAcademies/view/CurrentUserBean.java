package personsAndAcademies.view;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;

import personsAndAcademies.authentication.Logout;
import personsAndAcademies.model.User;

@Named("currentUserBean")
@SessionScoped
public class CurrentUserBean extends EntityBean<User> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private File tempFolder;
		private String oldPass;
		private String newPass;
		private String newPass2;
		
		@Inject
		private Logout logout;
		
		@PostConstruct
		public void createFolder(){
			e=new User();
			
			// mudar pasta de destino
			String filename = "Uploads"; //nao mudar este nome!!!!!!!!!!!
			String workingDirectory = System.getProperty("jboss.server.data.dir"); //vai buscar directory mas com um extra "/data"
			workingDirectory = workingDirectory.replace(File.separator+"data", ""); //elimina "/data" - substitui por vazio
			String absolutPath = workingDirectory + File.separator + "deployments"+ File.separator + "UPACADEMY_DB.war"+ File.separator + "resources" + File.separator + filename; //ATENCAO!!!!!!! perguntar ao luis se isto vai funcionaar XD
			tempFolder = new File(absolutPath);
			tempFolder.mkdir();
		}
		
		public void initCurrentUser(){
			e.setUsername((String) SecurityUtils.getSubject().getPrincipal());
			e=read();
			update();
		}
		
		public String role(){
			String user = (String)SecurityUtils.getSubject().getPrincipal();
			//String user = (String)SecurityUtils.getSubject().checkRole(roleIdentifier);
			if (user.equals("admin")) {
				return "/WEB-INF/layouts/commonHeaderAdmin.xhtml";
			} else {
				return "/WEB-INF/layouts/commonHeaderUser.xhtml";
			}
		}
		
		public void changePass(){
		if (!newPass.equals(newPass2)) {
			defineGrowl("Erro!", "Confirmação de password deve ser igual à password definida!", "changePass");
		} else if (oldPass.equals(e.getPassword()) && newPass.equals(newPass2)) {
				e.setPassword(newPass);
				update();
				defineGrowl("Password alterada com sucesso!", " ", "changePass");
				
				try {
					logout.submit();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else{
				defineGrowl("Passoword antiga está incorreta.", "", "changePass");
			}
		}
		
//		@Inject
//		private AcademyService acadRepo;
//		
//		@Override
//		public void update(){
//			if (e.getAcademy()!=null) {
////				e.setLanguageProgramming(acadRepo.readName(e.getAcademy()).getProgrammingLanguage());
//			}
//			service.update(e);
//			defineGrowl("Success!", "Entity was updated!", "update");
//		}
	
		
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

		public String getOldPass() {
			return oldPass;
		}

		public void setOldPass(String oldPass) {
			this.oldPass = oldPass;
		}

		public String getNewPass() {
			return newPass;
		}

		public void setNewPass(String newPass) {
			this.newPass = newPass;
		}

		public String getNewPass2() {
			return newPass2;
		}

		public void setNewPass2(String newPass2) {
			this.newPass2 = newPass2;
		}	
	}
