package personsAndAcademies.view;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
	
	private UploadedFile file;
	
	public void uploadImg(FileUploadEvent event) throws IOException{
		
		//obter ficheiro
		file = event.getFile();
		
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
		currentUser.getE().setPhoto(File.separator+filePath);
		currentUser.update();
		
		displayMsg();
	}
	
	public void uploadCurriculum(FileUploadEvent event) throws IOException{

		//obter ficheiro
		file = event.getFile();
		
		//byte[] - array de bytes
		byte[] fileBytes = file.getContents();
		
		//caminho de ficheiro
		String filePath = file.getFileName();
		
		//obtem o caminho necessário
		File tempFolder = currentUser.getTempFolder();
		
		//guarda numa pasta
		FileOutputStream fos = new FileOutputStream(tempFolder.getAbsolutePath()+File.separator+filePath);
		fos.write(fileBytes); 
		fos.close();
		
		// mete caminho na base de dados
		currentUser.getE().setCurriculum(File.separator+filePath);
		currentUser.update();
        FacesContext context = FacesContext.getCurrentInstance();
        if(file != null) {
            context.addMessage(null, new FacesMessage("Succesful", file.getFileName() + " is uploaded."));
        } else {
            context.addMessage(null, new FacesMessage("File not uploaded!"));
        }
		
		displayMsg();
		
	}

    public void displayMsg() {
        FacesContext context = FacesContext.getCurrentInstance();
        if(file != null) {
            context.addMessage(null, new FacesMessage("Succesful", file.getFileName() + " is uploaded."));
        } else {
            context.addMessage(null, new FacesMessage("File not uploaded!"));
        }
    }
}
