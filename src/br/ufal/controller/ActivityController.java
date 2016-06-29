package br.ufal.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import br.ufal.model.Activity;
import br.ufal.model.Database;
import br.ufal.model.User;

public class ActivityController {
	private static Hashtable<Integer, String> activityType;

	public ActivityController() {
		activityType = new Hashtable<Integer, String>();
		activityType.put(1, "Aula tradicional");
		activityType.put(2, "Apresentação");
		activityType.put(3, "Laboratório");
	}

	public Activity createActivity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Selecione o tipo de atividade:\n1. Aula tradicional\n2. Apresentação\n3. Laboratório");
		Integer type = Integer.parseInt(scanner.nextLine());
		System.out.println("Título:");
		String title = scanner.nextLine();
		Activity activity = new Activity(title, activityType.get(type));
		System.out.println("Atividade cadastrada: " + activity);
		return activity;
	}

	public Activity selectActivity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escolha uma atividade:");
		Database.getInstance().showActivities();
		Activity activity = Database.getInstance().getActivityById(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Atividade selecionada: " + activity);
		return activity;
	}

	public void editActivities() {
		Activity activity = selectActivity();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Atributo a ser editado:\n1. Título\n2. Descrição\n3. Material de Suporte"
				+ "\n4. Adicionar Participantes");

		switch(scanner.nextLine()){
		case "1":
			activity.setTitle(scanner.nextLine());
		case "2":
			activity.setDescription(scanner.nextLine());
		case "3":
			activity.setSupportMaterial(scanner.nextLine());
		case "4":
			System.out.println("Selecione o ID de um usuário:");
			for (User u :activity.getParticipants()){
				System.out.println(u);
			}
			User user = Database.getInstance().getUserById(scanner.nextInt());
			activity.addParticipant(user);			
		}
		
	}
}
