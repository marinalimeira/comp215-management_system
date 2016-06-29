package br.ufal.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
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
		

		int choose = 0;
		do {
			System.out.println("Selecione uma opção:\n1. Novo usuário\n2. Alocação de Recurso"
					+ "\n3. Gerenciar Atividades\n4. Consulta por Usuário\n5. Consulta por Recurso"
					+ "\n6. Relatório de Atividades\n10. Sair");

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
					resource.setStartDateTime(resourceController.createDate());
					resource.setEndDateTime(resourceController.createDate());
				}

				Database.getInstance().addResource(resource);
				System.out.println("Recurso cadastrado:\n" + resource);
				break;
			case "3":
				activityController.editActivities();
				break;
			}

		} while (choose != 10);
	}
}