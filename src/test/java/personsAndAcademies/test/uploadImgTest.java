package personsAndAcademies.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import personsAndAcademies.view.CurrentUserBean;
import personsAndAcademies.view.UploadBean;


@RunWith(Silent.class)
public class uploadImgTest {
	
//	@Mock
//	private Repository repositiry;
	
//	@Mock
//	private UploadBean bean;

	@Test
	public void test() throws IOException {
		
		//criar pasta
		String filename = "Uploads"; //nao mudar este nome!!!!!!!!!!!
		String workingDirectory = System.getProperty("user.dir");
		String absolutPath = workingDirectory + File.separator + filename; 
		File tempFolder = new File(absolutPath);
		tempFolder.mkdir();
		
		//Setup
		UploadBean bean = new UploadBean();
	    File file = new File("src/main/webapp/resources/images/logo.jpg");
	    
	    FileUploadEvent event = Mockito.mock(FileUploadEvent.class);
	    UploadedFile uploadedFile = Mockito.mock(UploadedFile.class);
	    CurrentUserBean currentUser = Mockito.mock(CurrentUserBean.class);
	    
//	    RuntimeException e = new RuntimeException();
	    
	    Mockito.when(event.getFile()).thenReturn(uploadedFile);
	    Mockito.when(uploadedFile.getContents()).thenReturn(Files.readAllBytes(file.toPath())); // file to byte array
	    Mockito.when(uploadedFile.getFileName()).thenReturn(file.getName());
	    Mockito.when(currentUser.getTempFolder()).thenReturn(tempFolder);
	    
	    //tratar disto
	    Mockito.doNothing().when(currentUser.getE()).setPhoto(null);
	    Mockito.doNothing().when(currentUser).update();

	    bean.setCurrentUser(currentUser);
	    
	    String path = bean.uploadImg(event);
  		
		Assert.assertEquals(absolutPath+File.separator+"logo.jpg", path);
		
	}
	
	@After
	public void end(){
		//fazer delete à pasta Uploads
	}
}

