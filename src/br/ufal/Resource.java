package br.ufal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Resource {

	private int id;
	private Date startDateTime;
	private Date endDateTime;
	private User responsible;
	private String status;
	private Activity activity;
	private DateFormat format;

	public Resource(User responsible, Activity activity) {
		this.status = "Em processo de alocação";
		this.responsible = responsible;
		this.activity = activity;
		this.format = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.US);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public User getResponsible() {
		return responsible;
	}

	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public String getStatus(){
		return status;
	}

	public void updateStatus() {
		if (this.status.equals("Em processo de alocação")) {
			if (this.startDateTime != null && this.endDateTime != null && this.responsible != null) {
				this.status = "Alocado";
				System.out.println("Status atualizado para Alocado.");
			} else {
				System.out.println("Status atualizado para Alocado.");
			}
		} else if (this.status.equals("Alocado")) {
			this.status = "Em andamento";
			System.out.println("Status atualizado para Em andamento.");
		} else if (this.status.equals("Em andamento")) {
			if (this.activity.getDescription() != null) {
				this.status = "Concluído";
				System.out.println("Status atualizado para Concluído.");
			} else {
				System.out.println("Adicione uma descrição a atividade antes de atualizar o status.");
			}

		}
		System.out.println("Não foi possível alterar o status!");
	}
	
	public String toString(){
		return 	id + " - " + status + "\n" + format.format(startDateTime) + " - " + format.format(endDateTime) + "\nResponsável: " + responsible.getName()
		+ "\nStatus: " + status + " | Atividade: " + activity.getTitle();
	}
}
