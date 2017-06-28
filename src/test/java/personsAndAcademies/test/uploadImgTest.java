package personsAndAcademies.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import personsAndAcademies.model.User;
import personsAndAcademies.view.CurrentUserBean;
import personsAndAcademies.view.UploadBean;

@RunWith(Silent.class)
public class uploadImgTest extends FacesContext{

	private File tempFolder;
	@Ignore
	@Test
	public void test() throws IOException {

		// criar pasta
		String filename = "Uploads"; // nao mudar este nome!!!!!!!!!!!
		String workingDirectory = System.getProperty("user.dir");
		String absolutPath = workingDirectory + File.separator + filename;
		tempFolder = new File(absolutPath);
		tempFolder.mkdir();

		// Setup
		UploadBean bean = new UploadBean();
		File file = new File("src/main/webapp/resources/images/logo.jpg");

		FileUploadEvent event = Mockito.mock(FileUploadEvent.class);
		UploadedFile uploadedFile = Mockito.mock(UploadedFile.class);
		CurrentUserBean currentUser = Mockito.mock(CurrentUserBean.class);
		FacesContext context = Mockito.mock(FacesContext.class);
		setCurrentInstance(context); 
		

		Mockito.when(event.getFile()).thenReturn(uploadedFile);
		Mockito.when(uploadedFile.getContents()).thenReturn(Files.readAllBytes(file.toPath())); 
																								
		Mockito.when(uploadedFile.getFileName()).thenReturn(file.getName());
		Mockito.when(currentUser.getTempFolder()).thenReturn(tempFolder);
		Mockito.doReturn(new User()).when(currentUser).getE();

		bean.setCurrentUser(currentUser);

		String path = bean.uploadImg(event);

		Assert.assertEquals(absolutPath + File.separator + "logo.jpg", path);

	}

	@After
	public void end() throws IOException {

		FileUtils.deleteDirectory(tempFolder);
	}

	@Override
	public Application getApplication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<String> getClientIdsWithMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExternalContext getExternalContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Severity getMaximumSeverity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<FacesMessage> getMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<FacesMessage> getMessages(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RenderKit getRenderKit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getRenderResponse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getResponseComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResponseStream getResponseStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResponseStream(ResponseStream responseStream) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseWriter getResponseWriter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResponseWriter(ResponseWriter responseWriter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UIViewRoot getViewRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setViewRoot(UIViewRoot root) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMessage(String clientId, FacesMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderResponse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void responseComplete() {
		// TODO Auto-generated method stub
		
	}
}
