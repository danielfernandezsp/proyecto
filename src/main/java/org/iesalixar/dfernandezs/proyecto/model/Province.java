package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Province implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, length = 10, nullable = false)
	private String name = "";
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "province")
	private Set<Event> events = new HashSet<Event>();
	
	public Province () {
		
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
