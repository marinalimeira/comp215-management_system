package br.ufal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Hashtable<Integer, String> userType = new Hashtable<Integer, String>();
		userType.put(1, "Aluno");
		userType.put(2, "Professor");
		userType.put(3, "Pesquisador");

		Hashtable<Integer, String> activityType = new Hashtable<Integer, String>();
		activityType.put(1, "Aula tradicional");
		activityType.put(2, "Apresentação");
		activityType.put(3, "Laboratório");

		int choose;

		do {
			System.out.println("Selecione uma opção:" + "\n1. Novo usuário" + "\n2. Alocação de Recurso"
					+ "\n3. Gerenciar Atividades" + "\n4. Relatório de Atividades" + "\n10. Sair");

			choose = scanner.nextInt();
			scanner.nextLine();

			if (choose == 1) {
				System.out.println("Nome: ");
				String name = scanner.nextLine();
				System.out.println("E-mail: ");
				String email = scanner.nextLine();
				System.out.println("Tipo:\n1. Aluno\n2. Professor\n3.Pesquisador");
				User newUser = new User(name, email, userType.get(scanner.nextInt()));
				scanner.nextLine();
				Database.getInstance().addUser(newUser);
				System.out.println(name + " cadastrado!");
			} else if (choose == 2) {
				System.out.println("Selecione o usuário responsável pela atividade:");
				Database.getInstance().showUsers();
				System.out.println("ID do usuário:");
				User user = Database.getInstance().getUserById(scanner.nextInt());
				scanner.nextLine();
				if (user == null) {
					System.out.println("Usuário não existe!\nSaindo..");
					// break;
				} else if (user.getType().equals("Aluno")) {
					System.out.println("Não é possível alocar um recurso para um aluno.\nSaindo...");
					// break;
				}

				Activity activity = null;
				System.out.println("A atividade já existe?\n1. Sim\n2. Não");
				int opc = scanner.nextInt();
				scanner.nextLine();
				switch (opc) {
				case 1:
					System.out.println("Escolha uma atividade:");
					Database.getInstance().showActivities();
					activity = Database.getInstance().getActivityById(scanner.nextInt());
					scanner.nextLine();
					System.out.println("Atividade selecionada: " + activity);
				case 2:
					System.out.println(
							"Selecione o tipo de atividade:\n1. Aula tradicional\n2. Apresentação\n3. Laboratório");
					Integer type = Integer.parseInt(scanner.nextLine());
					System.out.println("Título:");
					String title = scanner.nextLine();
					activity = new Activity(title, activityType.get(type));
					System.out.println("Atividade cadastrada: " + activity);
				}

				Resource resource = new Resource(user, activity);

				Database.getInstance().addResource(resource);

				System.out.println("Deseja cadastrar as datas?\n 1. Sim \n2. Não");
				opc = scanner.nextInt();
				scanner.nextLine();
				if (opc == 1) {
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.US);
					System.out.println("Insira a data e hora de início no formato dd-MM-yyyy HH:mm\n");
					System.out.println("Por exemplo, agora são " + format.format(new Date()));
					Date startDate = null;
					while (startDate == null) {
						String line = scanner.nextLine();
						try {
							startDate = format.parse(line);
						} catch (Exception e) {
							System.out.println("Data inválida. Insira novamente.");
						}
					}

					System.out.println("Insira a data e hora de início no formato dd-MM-yyyy HH:mm\n");
					System.out.println("Por exemplo, agora são " + format.format(new Date()));
					Date endDate = null;
					while (endDate == null) {
						String line = scanner.nextLine();
						try {
							endDate = format.parse(line);
						} catch (Exception e){
							System.out.println("Data inválida. Insira novamente.");
						}
					}

				}
				System.out.println("Recurso cadastrado:\n" + resource);

			}
		} while (choose != 10);
	}
}
