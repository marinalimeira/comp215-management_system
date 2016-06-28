package br.ufal;

import java.util.ArrayList;

public class User {

	private int id;
	private String name;
	private String email;
	private ArrayList<Resource> allocatedResources;
	private String type;

	public User(String name, String email, String type) {
		this.name = name;
		this.email = email;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getType() {
		return type;
	}

	public boolean allocateResource(Resource resource) {
		if (getResourceByStatus("Em andamento") != null) {
			System.out.println(
					"Não é possível alocar um recurso enquanto o usuário tem mais de um recurso Em andamento!");
			return false;
		}
		allocatedResources.add(resource);
		return true;
	}

	public Resource getResourceByStatus(String status) {
		for (Resource r : allocatedResources) {
			if (r.getStatus().equals(status)) {
				return r;
			}
		}
		return null;
	}

	public String toString() {
		return id + " - " + type + "\n" + name + "\n" + email;
	}
}
