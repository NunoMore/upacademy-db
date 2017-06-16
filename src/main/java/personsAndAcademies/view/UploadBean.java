package personsAndAcademies.view;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="uploadBean")
@RequestScoped
public class UploadBean {

	@Inject
	private CurrentUserBean currentUser;
	
	public void uploadImg(FileUploadEvent event) throws IOException{
		
		UploadedFile file = event.getFile();
		currentUser.getPerson().setPhoto(file.getContents());
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(file.getContents()));
		currentUser.setImg(img);
		
		
//		If you know the type of image and only want to generate a file, there's no need to get a BufferedImage instance. Just write the bytes to a file with the correct extension.
//
//		OutputStream out = null;
//
//		try {
//		    out = new BufferedOutputStream(new FileOutputStream(path));
//		    out.write(bytes);
//		} finally {
//		    if (out != null) out.close();
//		}
		
//		try {
//			if (file != null) {
//				
//				Class.forName("com.mysql.jdbc.Driver");
//				System.out.println(123);
//				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/upacademy_db_ds?user=root&password=!123456q");
//				
//				PreparedStatement st = cn.prepareStatement("UPDATE Person SET photo="+file.getContents()+" WHERE Person.username='"+currentUser.getPerson().getUsername()+"'");
//				
//				st.executeUpdate();
//				cn.close();
//				
//				FacesMessage message = new FacesMessage("Sucesso - ", file.getFileName() + " uploaded!");
//				FacesContext.getCurrentInstance().addMessage(null, message);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			FacesMessage message = new FacesMessage("Erro! Upload sem sucesso!");
//			FacesContext.getCurrentInstance().addMessage(null, message);
//		}
	}

}
