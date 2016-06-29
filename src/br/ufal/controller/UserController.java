package br.ufal.controller;

import java.util.Hashtable;
import java.util.Scanner;

import br.ufal.model.Database;
import br.ufal.model.User;

public class UserController {
	private static Hashtable<Integer, String> userType;

	public UserController() {
		userType = new Hashtable<Integer, String>();
		userType.put(1, "Aluno");
		userType.put(2, "Professor");
		userType.put(3, "Pesquisador");
		userType.put(3, "Administrador");
	}

	public User createUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome: ");
		String name = scanner.nextLine();
		System.out.println("E-mail: ");
		String email = scanner.nextLine();
		System.out.println("Tipo:\n1. Aluno\n2. Professor\n3.Pesquisador");
		User newUser = new User(name, email, userType.get(scanner.nextInt()));
		scanner.nextLine();
		Database.getInstance().addUser(newUser);
		System.out.println(name + " cadastrado!");
		return newUser;
	}

	public User selectUserToAllocate() {
		Scanner scanner = new Scanner(System.in);
		User user = null;
		while (user == null) {
			System.out.println("Selecione o usuário responsável pela atividade:");
			Database.getInstance().showUsers();
			System.out.println("ID do usuário:");
			user = Database.getInstance().getUserById(scanner.nextInt());
			scanner.nextLine();
			if (user == null)
				System.out.println("Usuário não existe!\nSelecione outro usuário...\n");
			else if (user.getType().equals("Aluno")) {
				user = null;
				System.out.println("Não é possível alocar um recurso para um aluno.\nSelecione outro usuário...\n");

			}
		}
		return user;
	}
}
