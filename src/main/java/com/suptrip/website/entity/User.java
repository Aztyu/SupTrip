package com.suptrip.website.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {
	
	@Id
	private int booster_id;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name="campus_fk")
	private Campus campus;
	
	public User() {
		super();
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
