package com.suptrip.website.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Campus start;
	
	@ManyToOne
	private Campus destination;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date tripDate;
	
	private String description;

	public int getId() {
		return id;
	}

	public Campus getStart() {
		return start;
	}

	public Campus getDestination() {
		return destination;
	}


	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStart(Campus start) {
		this.start = start;
	}

	public void setDestination(Campus destination) {
		this.destination = destination;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}
}
