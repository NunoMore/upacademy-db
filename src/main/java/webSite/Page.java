package webSite;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("page")
@SessionScoped
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String currentPage;
	
	public void mainPage() {
		currentPage = "main-page";
	}

	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	

}
