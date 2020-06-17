package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min = 3, max = 15, message = "El nombre debe tener mas de 3 letras y menos de 15.")
	@Column(length = 15, nullable = false)
	private String name = "";
	
	@NotEmpty
	@Size(min = 6, max = 50)
	@Column(length = 50, nullable = false)
	private String lastName = "";
	
	@NotEmpty
	@Column(length = 20, nullable = false, unique = true)
	private String username = "";
	
	@NotEmpty
	@Column(length = 255, nullable = false)
	private String password = "";
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Authority> authority = new HashSet<Authority>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Event> events = new HashSet<Event>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Comment> comments = new HashSet<Comment>();
	
	@Lob
	@Column (name = "image")
	private String image;
	
	public User() {
		
	}
	
	public long getId() {
		return id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
