package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Forum implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
    @JoinColumn(name = "FK_EVENT", updatable = false, nullable = false)
	private Event event = null;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forum")
	private Set<Comment> comments = new HashSet<Comment>();
	
	public Forum() {
		
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
	

}
