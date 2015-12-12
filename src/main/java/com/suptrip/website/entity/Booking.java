package com.suptrip.website.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Trip trip_booked;
	
	@ManyToOne
	private User user;

	public int getId() {
		return id;
	}

	public Trip getTrip_booked() {
		return trip_booked;
	}

	public User getUser() {
		return user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTrip_booked(Trip trip_booked) {
		this.trip_booked = trip_booked;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

