package personsAndAcademies.view;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="uploadBean")
@RequestScoped
public class UploadBean {

	@Inject
	private CurrentUserBean currentUser;
	
	private StreamedContent userImage;
	
	
	public void uploadImg(FileUploadEvent event) throws IOException{
		
		UploadedFile file = event.getFile();
		currentUser.getPerson().setPhoto(file.getFileName());
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(file.getContents()));
		ImageIO.write(img, "jpg", new File("//C:/Users/Utilizador/Desktop/Projeto/repositorioGit/src/main/webapp/resources/temp_user_photos/testImage.png"));
										//C:/Users/Utilizador/Desktop/Projeto/repositorioGit/src/main/webapp/resources/temp_user_photos/"
		
	}
	
	
/*	public void displayImg (){
		

		BufferedImage img = ImageIO.read(new ByteArrayInputStream(file.getContents()));	
		//isto poe a imagem ja em formato jpg num ficheiro "local" neste exemplo no meu disco, agora falta o resto
		// o que eu penso e que se pode enviar para uma pasta "temp-user-photos criada na pasta resources, COMO SE POE ESSE CAMINHO?
		ImageIO.write(img, "jpg", new File("C:/Users/Utilizador/Desktop/Projeto/repositorioGit/src/main/webapp/resources/temp_user_photos/imageTester.png"));
		userImage = new DefaultStreamedContent(new ByteArrayInputStream(file.getContents()), "C:/Users/Utilizador/Desktop/Projeto/repositorioGit/src/main/webapp/resources/temp_user_photos/imageTester.png");
	
	}*/
			
//		If you know the type of image and only want to generate a file, there's no need to get a BufferedImage instance. Just write the bytes to a file with the correct extension.

	public StreamedContent getUserImage() {
		return userImage;
	}

	public void setUserImage(StreamedContent userImage) {
		this.userImage = userImage;
	}

	

}
