package com.suptrip.website.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({"remaining_time"})
public class Trip {
	static final long serialVersionUID = 564545644L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@JsonProperty("start_campus")
	@ManyToOne
	private Campus start;
	
	@JsonProperty("destination_campus")
	@ManyToOne
	private Campus destination;
	
	@JsonProperty("departure_date")
	@Temporal(TemporalType.TIMESTAMP)
    private Date tripDate;
	
	@Transient
	private Period remaining_time;
	
	@Column(columnDefinition = "TEXT")
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
	
	public String getRemaining_time() {
		PeriodFormatter pf = new PeriodFormatterBuilder()
		    .appendDays()
		    .appendSuffix(" day", " days")
		    .appendSeparator(" and ")
		    .appendHours()
		    .appendSuffix(" hour"," hours")
		    .appendSeparator(" and ")
		    .appendMinutes()
		    .appendSuffix(" minute", " minutes")
		    .toFormatter();
		return pf.print(remaining_time);
	}

	public void updateDuration(){
		Period p = new Period(new DateTime(), new DateTime(tripDate.getTime()));
		this.remaining_time = p;
	}
}
