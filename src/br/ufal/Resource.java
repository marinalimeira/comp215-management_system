package br.ufal;
import java.util.Date;

public class Resource {

	private int id;
	private Date startDateTime;
	private Date endDateTime;
	private User responsible;
	private String status;
	
	public Resource(int id, Date startDateTime, Date endDateTime, User responsible) {
		this.id = id;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.responsible = responsible;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
