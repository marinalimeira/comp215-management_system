package br.ufal.model;

import java.util.ArrayList;

public class Database {
	private static Database instance = new Database();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private ArrayList<Resource> resources = new ArrayList<Resource>();
	private int userIndex = 0;
	private int activityIndex = 0;
	private int resourceIndex = 0;

	public static Database getInstance() {
		return instance;
	}

	public void addUser(User u) {
		u.setId(userIndex++);
		users.add(u);
	}
	
	public void addActivity(Activity a) {
		a.setId(activityIndex++);
		activities.add(a);
	}
	
	public void addResource(Resource r) {
		r.setId(resourceIndex++);
		resources.add(r);
	}
	
	public User getUserByEmail(String email) {
		for (User u : users) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}
	
	public User getUserById(int id) {
		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
	public void showUsers(){
		for (User u : users) {
			System.out.println(u + "\n");
		}
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public Activity getActivityById(int id){
		for (Activity a : activities) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	public void showActivities(){
		for (Activity a : activities) {
			System.out.println(a + "\n");
		}
	}
	
	public void showActivitiesByType(){
		int traditional_class = 0;
		int lecture = 0;
		int laboratory = 0;
		
		for (Activity a : activities) {
			if (a.getType().equals("Aula tradicional"))
				traditional_class++;
			else if (a.getType().equals("Apresentação"))
				lecture++;
			else if (a.getType().equals("Laboratório"))
				laboratory++;
		}
		System.out.println("Aula tradicional: " + traditional_class);
		System.out.println("\nApresentação: " + lecture);
		System.out.println("\nLaboratório: " + laboratory);
	}
	
	public Resource getResourceById(int id) {
		for (Resource r : resources) {
			if (r.getId() == id) {
				return r;
			}
		}
		return null;
	}
	
	public ArrayList<Resource> getResources() {
		return resources;
	}
	
	public void showResourcesByStatus() {
		int in_allocation = 0;
		int allocated = 0;
		int on_going = 0;
		int completed = 0;
		
		for (Resource r : resources) {
			if (r.getStatus().equals("Em processo de alocação"))
				in_allocation++;
			else if (r.getStatus().equals("Alocado"))
				allocated++;
			else if (r.getStatus().equals("Em andamento"))
				on_going++;
			else if (r.getStatus().equals("Concluído"))
				completed++;
		}
		
		System.out.println("Em processo de alocação: " + in_allocation);
		System.out.println("\nAlocado: " + allocated);
		System.out.println("\nEm andamento: " + on_going);
		System.out.println("\nConcluído: " + completed);
	}
}
