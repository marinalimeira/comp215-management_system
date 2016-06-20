package br.ufal;

import java.util.ArrayList;

public class User {
	
	private String name;
	private String email;
	private ArrayList<Resource> allocatedResources = new ArrayList<Resource>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public ArrayList<Resource> getAllocatedResources() {
		return allocatedResources;
	}
	
	public void setAllocatedResources(ArrayList<Resource> allocatedResources) {
		this.allocatedResources = allocatedResources;
	}
}
