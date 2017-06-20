package personsAndAcademies.view;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="uploadBean")
@RequestScoped
public class UploadBean {

	@Inject
	private CurrentUserBean currentUser;
	
	public void uploadImg(FileUploadEvent event) throws IOException{
		
		//obter ficheiro
		UploadedFile file = event.getFile();
		
		//byte[] - array de bytes
		byte[] fileBytes = file.getContents();
		
		//byte[] to bufferedImage
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(fileBytes));
		
		//caminho de ficheiro
		String filePath = file.getFileName();
		
		//guarda extensao de ficheiro
		String extension = FilenameUtils.getExtension(filePath);
		
		//obtem o caminho necessário
		File tempFolder = currentUser.getTempFolder();
		
		//guarda numa pasta
		File photo = new File(tempFolder, filePath);
		ImageIO.write(img, extension, photo);
		
		// mete caminho na base de dados
		currentUser.getPerson().setPhoto(File.separator+filePath);
		currentUser.updateUser();
		
	}
}
