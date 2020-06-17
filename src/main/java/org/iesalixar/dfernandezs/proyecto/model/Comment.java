package org.iesalixar.dfernandezs.proyecto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "FK_USER", nullable = false, updatable = false)
	private User user = null;
	
	@Column(nullable = false)
	private Date date = null;
	
	@Column(nullable = false)
	private String text = "";
	
	@ManyToOne
    @JoinColumn(name = "FK_FORUM", nullable = false, updatable = false)
	private Forum forum;
	
	
	public Comment () {
		
	}


	public Comment(User user, Date date, String text, Forum forum) {
		super();
		this.user = user;
		this.date = date;
		this.text = text;
		this.forum = forum;
	}


	
	
	public long getId() {
		return id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Forum getForum() {
		return forum;
	}


	public void setForum(Forum forum) {
		this.forum = forum;
	}

	

}
