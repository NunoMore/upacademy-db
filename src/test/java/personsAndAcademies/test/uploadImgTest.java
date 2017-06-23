package personsAndAcademies.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.enterprise.inject.New;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import personsAndAcademies.model.Person;
import personsAndAcademies.view.CurrentUserBean;
import personsAndAcademies.view.UploadBean;


@RunWith(Silent.class)
public class uploadImgTest {
	
	private File tempFolder;

	@Test
	public void test() throws IOException {
		
		//criar pasta
		String filename = "Uploads"; //nao mudar este nome!!!!!!!!!!!
		String workingDirectory = System.getProperty("user.dir");
		String absolutPath = workingDirectory + File.separator + filename; 
		tempFolder = new File(absolutPath);
		tempFolder.mkdir();
		
		//Setup
		UploadBean bean = new UploadBean();
	    File file = new File("src/main/webapp/resources/images/logo.jpg");
	    
	    FileUploadEvent event = Mockito.mock(FileUploadEvent.class);
	    UploadedFile uploadedFile = Mockito.mock(UploadedFile.class);
	    CurrentUserBean currentUser = Mockito.mock(CurrentUserBean.class);
	    	    
	    Mockito.when(event.getFile()).thenReturn(uploadedFile);
	    Mockito.when(uploadedFile.getContents()).thenReturn(Files.readAllBytes(file.toPath())); // file to byte array
	    Mockito.when(uploadedFile.getFileName()).thenReturn(file.getName());
	    Mockito.when(currentUser.getTempFolder()).thenReturn(tempFolder);
	    Mockito.doReturn(new Person()).when(currentUser).getE();

	    bean.setCurrentUser(currentUser);
	    
	    String path = bean.uploadImg(event);
  		
		Assert.assertEquals(absolutPath+File.separator+"logo.jpg", path);
		
	}
	
	@After
	public void end() throws IOException{

		FileUtils.deleteDirectory(tempFolder);
	}
}

