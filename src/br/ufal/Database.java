package br.ufal;

import java.util.ArrayList;

public class Database {
	private static Database instance = new Database();
	private ArrayList<User> users = new ArrayList<User>();
	private int index = 0;
	
	 public static Database getInstance(){
	      return instance;
	   }

	public void addUser(User u) {
		u.setId(index++);
		users.add(u);
	}
}
