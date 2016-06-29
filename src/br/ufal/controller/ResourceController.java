package br.ufal.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ResourceController {
	public Date createDate() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insira a data e hora de início no formato dd/MM/yyyy HH:mm\n");
		System.out.println("Por exemplo, agora são " + format.format(new Date()));
		Date date = null;
		while (date == null) {
			String line = scanner.nextLine();
			try {
				date = format.parse(line);
			} catch (Exception e) {
				System.out.println("Data inválida. Insira novamente.");
			}
		}
		return date;
	}
}
