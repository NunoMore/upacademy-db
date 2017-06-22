package personsAndAcademies.test;

import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import personsAndAcademies.view.CurrentUserBean;
import personsAndAcademies.view.PersonBean;
import personsAndAcademies.view.UploadBean;


@RunWith(MockitoJUnitRunner.class)
public class uploadImgTest {
	
//	@Mock
//	private Repository repositiry;
	
//	@Mock
//	private UploadBean bean;

	@Test
	public void test() throws IOException {
		
		PersonBean person = new PersonBean();
		CurrentUserBean user = new CurrentUserBean();	
		
		
		UploadBean bean = new UploadBean();
	    File file = new File("src/main/webapp/resources/images/logo.jpg");
	    
	    InputStream inputStream = new FileInputStream(file);
	    FileUploadEvent event = Mockito.mock(FileUploadEvent.class);
	    
	    UploadedFile uploadedFile = Mockito.mock(UploadedFile.class);
	  	
	    Mockito.when(uploadedFile.getFileName()).thenReturn(file.getName());
	    Mockito.when(uploadedFile.getContentType()).thenReturn("application/octet-stream");
	    Mockito.when(uploadedFile.getContents()).thenReturn(Files.readAllBytes(file.toPath())); // file to byte array
	  //  Mockito.when(user.getE()).thenReturn());
	    
	   
	    //current user em falta
	    
	    Mockito.when(uploadedFile.getInputstream()).thenReturn(inputStream);
	    Mockito.when(event.getFile()).thenReturn(uploadedFile);
	    
	    String path = bean.uploadImg(event);
		
		Assert.assertEquals("C:"+File.separator+"wildfly-10.1.0.Final"+File.separator+"wildfly-10.1.0.Final"+File.separator+"standalone"+File.separator+""
				+ "deployments"+File.separator+"UPACADEMY_DB.war"+File.separator+"resources"+File.separator+"Uploads"+File.separator+"logo.jpg", path);
		
	}
}

