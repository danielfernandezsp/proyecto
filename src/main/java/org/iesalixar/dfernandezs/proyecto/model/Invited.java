package org.iesalixar.dfernandezs.proyecto.model;

public class Invited {

	private long id;
	private String user;
	private String password;
	private Event event;
	
	public Invited() {
		
	}

	public Invited(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	
}
