package personsAndAcademies.view;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "uploadBean")
@RequestScoped
public class UploadBean extends GrowlBean {

	@Inject
	private CurrentUserBean currentUser;

	public String uploadImg(FileUploadEvent event) throws IOException {
		UploadedFile uploadfile = null;
		File file = null;
		
		if (event.getFile() != null) {

			// obter ficheiro
			uploadfile = event.getFile();

			// byte[] - array de bytes
			byte[] fileBytes = uploadfile.getContents();

			// byte[] to bufferedImage
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(fileBytes));

			// caminho de ficheiro
			String filePath = uploadfile.getFileName();

			// guarda extensao de ficheiro
			String extension = FilenameUtils.getExtension(filePath);

			// obtem o caminho necessário
			File tempFolder = currentUser.getTempFolder();

			// guarda numa pasta
			file = new File(tempFolder, filePath);
			ImageIO.write(img, extension, file);

			// mete caminho na base de dados
			currentUser.getE().setPhoto(File.separator + filePath);
			currentUser.update();
		}

		if (uploadfile != null) {
			defineGrowl("Success! ", uploadfile.getFileName() + " is uploaded!", "uploads");
		} else {
			defineGrowl("Error!", "Upload was unsucceful", "uploads");
		}

		return file.getAbsolutePath();
	}

	public void uploadCurriculum(FileUploadEvent event) throws IOException {

		UploadedFile file = null;

		if (event.getFile() != null) {
			// obter ficheiro
			file = event.getFile();

			// byte[] - array de bytes
			byte[] fileBytes = file.getContents();

			// caminho de ficheiro
			String filePath = file.getFileName();

			// obtem o caminho necessário
			File tempFolder = currentUser.getTempFolder();

			// guarda numa pasta
			FileOutputStream fos = new FileOutputStream(tempFolder.getAbsolutePath() + File.separator + filePath);
			fos.write(fileBytes);
			fos.close();

			// mete caminho na base de dados
			currentUser.getE().setCurriculum(File.separator + filePath);
			currentUser.update();
		}

		if (file != null) {
			defineGrowl("Success! ", file.getFileName() + " is uploaded!", "uploads");
		} else {
			defineGrowl("Error!", "Upload was unsucceful", "uploads");
		}

	}

	public CurrentUserBean getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUserBean currentUser) {
		this.currentUser = currentUser;
	}
}
