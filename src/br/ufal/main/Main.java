package br.ufal.main;

import java.util.Scanner;

import br.ufal.controller.*;
import br.ufal.model.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ActivityController activityController = new ActivityController();
		UserController userController = new UserController();
		ResourceController resourceController = new ResourceController();

		User teacher = new User("Carlos", "carlos@gmail.com", "Professor");
		Database.getInstance().addUser(teacher);

		User student = new User("Valeska", "valeska@gmail.com", "Aluno");
		Database.getInstance().addUser(student);

		User researcher = new User("Ana", "ana@gmail.com", "Pesquisador");
		Database.getInstance().addUser(researcher);

		User admin = new User("Admin", "admin@gmail.com", "Administrador");
		Database.getInstance().addUser(admin);

		while (true) {
			System.out.println("Selecione uma opção:\n1. Novo usuário\n2. Alocação de Recurso"
					+ "\n3. Atualizar recurso"
					+ "\n4. Gerenciar Atividades\n5. Consulta por Usuário\n6. Consulta por Recurso"
					+ "\n7. Relatório de Atividades\n10. Sair");

			switch (scanner.nextLine()) {
			case "1":
				userController.createUser();
				break;
			case "2":
				User user = userController.selectUserToAllocate();
				Activity activity = null;

				System.out.println("A atividade já existe?\n1. Sim\n2. Não");

				switch (scanner.nextLine()) {
				case "1":
					activity = activityController.selectActivity();
					break;
				case "2":
					activity = activityController.createActivity();
					break;
				}

				Resource resource = new Resource(user, activity);

				System.out.println("Deseja cadastrar as datas?\n1. Sim \n2. Não");

				if (scanner.nextLine().equals("1")) {
					System.out.println("Insira a data e hora de início no formato dd/MM/yyyy HH:mm");
					resource.setStartDateTime(resourceController.createDate());
					System.out.println("Insira a data e hora de término no formato dd/MM/yyyy HH:mm");
					resource.setEndDateTime(resourceController.createDate());
				}

				Database.getInstance().addResource(resource);
				System.out.println("Recurso cadastrado:\n" + resource + "\n");
				break;
			case "3":
				resourceController.updateResourceStatus();
				break;
			case "4":
				activityController.editActivities();
				break;
			case "5":
				System.out.print("ID do usuário a ser consultado: ");
				User u = Database.getInstance().getUserById(scanner.nextInt());
				scanner.nextLine();
				System.out.println(u);
				break;				
			case "6":
				System.out.print("ID do recurso a ser consultado: ");
				Resource r = Database.getInstance().getResourceById(scanner.nextInt());
				scanner.nextLine();
				System.out.println(r);
				break;
			case "7":
				System.out.println("Número de usuários: " + Database.getInstance().getUsers().size());
				System.out.println("Número de recurso por status:\n");
				Database.getInstance().showResourcesByStatus();
				System.out.println("Número de alocações: " + Database.getInstance().getResources().size());
				System.out.println("Número de atividades de acordo com o tipo:\n");
				Database.getInstance().showActivitiesByType();
				break;
			case "10":
				break;
			}
		}
	}
}