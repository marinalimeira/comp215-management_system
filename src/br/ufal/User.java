package br.ufal;

import java.util.ArrayList;

public class User implements Comparable<User> {

	protected int id;
	protected String name;
	protected String email;
	protected ArrayList<Resource> allocatedResources;

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
}
