package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Event implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long event_id;
	
	@Column(nullable = false)
	private boolean allow = false;
	
	@Column(unique = true, length = 50, nullable = false)
	private String name = "";
	
	@Column(length = 500, nullable = false)
	private String description = "";
	
	@Column(nullable = true)
	private int capacity = 0;
	
	@Column(nullable = false)
	private Date date;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(nullable = false)
	private Date start_event;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(nullable = true)
	private Date end_event;
	
	@ManyToOne
    @JoinColumn(name = "FK_PROVINCE", nullable = false, updatable = false)
	private Province province = null;
	
	@ManyToMany
	@JoinTable(
	  name = "Category_Event", 
	  joinColumns = @JoinColumn(name = "event_id"), 
	  inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	@ManyToOne
    @JoinColumn(name = "FK_USER", nullable = false, updatable = false)
	private User user = null;
	
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
	private Forum forum = null;

	@Column(length = 700, nullable = false)
	private String place = "";
	
	@Column(nullable = true)
	private String webSite = "";
		
	@Lob
	@Column (name = "image")
	private String image;
	
	public Event () {
		
	}

	public Event(String name, String description, int capacity, Date date, Date start_event, Date end_event, Province province,
			Set<Category> categories, User user, String place, String webSite, String image) {
		super();
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.date = date;
		this.start_event = start_event;
		this.end_event = end_event;
		this.province = province;
		this.categories = categories;
		this.user = user;
		this.forum = new Forum();
		this.place = place;
		this.webSite = webSite;
		this.image = image;
	}

	
	
	public long getEvent_id() {
		return event_id;
	}

	public boolean getAllow() {
		return allow;
	}

	public void setAllow(boolean allow) {
		this.allow = allow;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
