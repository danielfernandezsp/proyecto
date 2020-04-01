package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, length = 20, nullable = false)
	private String name = "";
	
	@ManyToOne
	@JoinColumn(name = "FK_EVENT", nullable = true, updatable = false)
	private Event event = null;
	
	public Category() {
		
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

	public Event getEvent() {
		return event;
	}

	public void setEvento(Event event) {
		this.event = event;
	}
	
	
}
