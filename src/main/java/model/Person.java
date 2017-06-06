package model;



import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private long ID;
	
	private String name;
	private String photo;
	private String academy;
	private int numTelephone;
	private String email;
	private String facebookLink;
	private String linkedInLink;
	private String gitHubLink;
	private String workPlace;
	private String curriculum;
	private String favoritesList;
	
	
	public String getName() {
		
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getID() {
		return ID;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public int getNumTelephone() {
		return numTelephone;
	}
	public void setNumTelephone(int numTelephone) {
		if(numTelephone<900000000 || numTelephone>999999999){
			throw new IllegalArgumentException("Number must be portuguese Cellphone");
		}else
		this.numTelephone = numTelephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacebookLink() {
		return facebookLink;
	}
	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}
	public String getLinkedInLink() {
		return linkedInLink;
	}
	public void setLinkedInLink(String linkedInLink) {
		this.linkedInLink = linkedInLink;
	}
	public String getGitHubLink() {
		return gitHubLink;
	}
	public void setGitHubLink(String gitHubLink) {
		this.gitHubLink = gitHubLink;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	public ArrayList<Long> getFavoritesList() {
		String[] favoriteListParts= favoritesList.split(",");
		ArrayList<Long> favoritelist =new ArrayList<Long>();
		for(String part : favoriteListParts){
			favoritelist.add(Long.valueOf(part));
		}
		return favoritelist;
	}
	public void setFavoritesList(ArrayList<Long> favoritesList) {
		this.favoritesList = favoritesList.toString();
	}

	
}