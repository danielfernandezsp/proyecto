package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 15, nullable = false)
	private String name = "";
	
	@Column(length = 50, nullable = false)
	private String lastName = "";
	
	@Column(unique = true, length = 50, nullable = false)
	private String email = "";
	
	@Column(length = 20, nullable = false, unique = true)
	private String username = "";
	
	@Column(length = 255, nullable = false)
	private String password = "";
	
	@Column(nullable = false)
	private LocalDateTime birthday = null;
	
//	@JoinTable(
//	        name = "user_rol",
//	        joinColumns = @JoinColumn(name = "user", nullable = false),
//	        inverseJoinColumns = @JoinColumn(name="rol", nullable = false)
//	    )
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Authority> authority = new HashSet<Authority>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Event> events = new HashSet<Event>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Comment> comments = new HashSet<Comment>();
	
	@Lob
	@Column (name = "image")
	private byte[] image;
	
	public User() {
		
	}

//	public User(String username, String password, String authority) {
//		this.username = username;
//		this.password = password;
//		this.authority = authority;
//	}
//	
//	public User(String name, String lastName, String email, String username, String password, LocalDateTime birthday, byte[] image) {
//		super();
//		this.name = name;
//		this.lastName = lastName;
//		this.email = email;
//		this.username = username;
//		this.password = password;
//		this.birthday = birthday;
//		this.image = image;
//	}

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

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

}
