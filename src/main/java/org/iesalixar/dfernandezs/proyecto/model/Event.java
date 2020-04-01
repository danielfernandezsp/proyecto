package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Event implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, length = 30, nullable = false)
	private String name = "";
	
	@Column(length = 250, nullable = false)
	private String description = "";
	
	@Column(nullable = false)
	private int capacity = 0;
	
	@Column(nullable = false)
	private Date start_event = null;
	
	@Column(nullable = false)
	private Date end_event = null;
	
	@ManyToOne
    @JoinColumn(name = "FK_PROVINCE", nullable = false, updatable = false)
	private Province province = null;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	private Set<Category> categories = new HashSet<>();
	
	@ManyToOne
    @JoinColumn(name = "FK_USER", nullable = false, updatable = false)
	private User user = null;
	
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
	private Forum forum = null;

	@Column(nullable = false)
	private String place = "";
		
	@Lob
	@Column (name = "image")
	private byte[] image;
	
	public Event () {
		
	}

	public Event(String name, String description, int capacity, Date start_event, Date end_event, Province province,
			Set<Category> categories, User user, String place, byte[] image) {
		super();
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.start_event = start_event;
		this.end_event = end_event;
		this.province = province;
		this.categories = categories;
		this.user = user;
		this.forum = new Forum();
		this.place = place;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Date getStart_event() {
		return start_event;
	}

	public void setStart_event(Date start_event) {
		this.start_event = start_event;
	}

	public Date getEnd_event() {
		return end_event;
	}

	public void setEnd_event(Date end_event) {
		this.end_event = end_event;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
