package br.ufal;

import java.util.ArrayList;

public class Activity {
	private String title;
	private String description;
	private String supportMaterial; // use file?
	private ArrayList<User> participants;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSupportMaterial() {
		return supportMaterial;
	}
	public void setSupportMaterial(String supportMaterial) {
		this.supportMaterial = supportMaterial;
	}
	public ArrayList<User> getParticipants() {
		return participants;
	}
	public void setParticipants(ArrayList<User> participants) {
		this.participants = participants;
	}
}
