package com.suptrip.website.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
	static final long serialVersionUID = 7852134L;
	
	@Id
	private int booster_id;
	
	@Column(columnDefinition = "TEXT")
	private String firstname;
	
	@Column(columnDefinition = "TEXT")
	private String lastname;
	
	@Column(columnDefinition = "TEXT")
	private String password;
	
	@Column(columnDefinition = "TEXT")
	private String email;
	
	@ManyToOne
	private Campus campus;
	
	public User() {
		super();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBooster_id() {
		return booster_id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Campus getCampus() {
		return campus;
	}
	
	public void setBooster_id(int booster_id) {
		this.booster_id = booster_id;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCampus(Campus campus) {
		this.campus = campus;
	}	
}
