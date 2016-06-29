package br.ufal.model;

import java.util.ArrayList;

public class Activity {
	
	private int id;
	private String title;
	private String description;
	private String supportMaterial; // use file?
	private ArrayList<User> participants;
	private String type;
	
	public Activity(String title, String type){
		this.title = title;
		this.type = type;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	
	public void addParticipant(User u){
		this.participants.add(u);
	}
	
	public String toString(){
		return id + " - " + title + "\nDescrição:" + description + "\nTipo:" + type;		
	}
}
