package org.iesalixar.dfernandezs.proyecto.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Admin{

	private long id = 0;
	private String name = "";
	private String lastName = "";
	private String user = "";
	private String password = "";
	private Date birthday = new Date();
	private Set<Event> events = new HashSet<Event>();
	
	
	public Admin() {
		
	}
	
	
	public Admin(String name, String lastName, String user, String password, Date birthday) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.user = user;
		this.password = password;
		this.birthday = birthday;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Set<Event> getEvents() {
		return events;
	}


	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	
	

}
