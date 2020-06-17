package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long category_id;
	
	@Column(unique = true, length = 20, nullable = false)
	private String name = "";
	
	@ManyToMany(mappedBy = "categories")
	private Set<Event> events = new HashSet<Event>();
	
	public Category() {
		
	}

	
	
	public long getCategory_id() {
		return category_id;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}


	
	
}
