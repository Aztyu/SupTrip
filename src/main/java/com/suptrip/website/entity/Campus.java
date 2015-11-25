package com.suptrip.website.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Campus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private int postal_code;
	
	@OneToMany(mappedBy="campus")
	private Collection<User> users;
	
	public Campus() {
		super();
	}

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getPostal_code() {
		return postal_code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}
}
