package br.ufal;

import java.util.ArrayList;

public class Database {
	private static Database instance = new Database();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private ArrayList<Resource> resources = new ArrayList<Resource>();
	private int index = 0;

	public static Database getInstance() {
		return instance;
	}

	public void addUser(User u) {
		u.setId(index++);
		users.add(u);
	}
	
	public void addActivity(Activity a) {
		a.setId(index++);
		activities.add(a);
	}
	
	public void addResource(Resource r) {
		r.setId(index++);
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
}
