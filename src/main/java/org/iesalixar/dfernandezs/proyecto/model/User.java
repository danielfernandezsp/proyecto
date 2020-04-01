package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 15, nullable = false)
	private String name = "";
	
	@Column(length = 50, nullable = false)
	private String lastName = "";
	
	@Column(unique = true, length = 50, nullable = false)
	private String email = "";
	
	@Column(length = 20, nullable = false)
	private String user = "";
	
	@Column(length = 20, nullable = false)
	private String password = "";
	
	@Column(nullable = true)
	private Date birthday = new Date();
	
	@Column(length = 6, nullable = false)
	private String rol = "";
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Event> events = new HashSet<Event>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Comment> comments = new HashSet<Comment>();
	
	@Lob
	@Column (name = "image")
	private byte[] image;
	
	public User() {
		
	}

	public User(String name, String lastName, String email, String user, String password, Date birthday, byte[] image) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.user = user;
		this.password = password;
		this.birthday = birthday;
		this.image = image;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

}
