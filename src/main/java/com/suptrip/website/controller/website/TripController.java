package com.suptrip.website.controller.website;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suptrip.website.dao.CampusDAO;
import com.suptrip.website.dao.TripDAO;
import com.suptrip.website.entity.Booking;
import com.suptrip.website.entity.Campus;
import com.suptrip.website.entity.Trip;
import com.suptrip.website.entity.User;

@Controller
public class TripController {
	@RequestMapping(value = "auth/trips", method = RequestMethod.GET)
	public String trip(HttpServletRequest req) {		//Show the form
		List<Campus> campus_list = CampusDAO.getAllCampus();		//Load campuses in case of error
		req.setAttribute("campus_list", campus_list);
		
		List<Trip> trips = TripDAO.getAllAvailableTrips();
		if(trips.size() > 0){
			req.setAttribute("trips", trips);
		}
		return "trip/trips";
	}
	
	@RequestMapping(value = "auth/trips", method = RequestMethod.POST)
	public String tripId(HttpServletRequest req) {		//Show the form
		List<Campus> campus_list = CampusDAO.getAllCampus();		//Load campuses in case of error
		req.setAttribute("campus_list", campus_list);
	
		String campus_id = req.getParameter("campus_id");
		if(campus_id != null){
			int campus_nb = Integer.parseInt(campus_id);
			if(campus_nb != -1){
				Campus request_campus = new Campus();
				for(Campus c : campus_list){
					if(c.getId() == campus_nb){
						request_campus = c;
						break;
					}
				}
				req.setAttribute("campus_id", campus_nb);
				
				List<Trip> trips = TripDAO.getTripsByCampusId(campus_nb);
				if(trips.size() > 0){
					req.setAttribute("trips", trips);
				}else{
					req.setAttribute("message", "No result found for " + request_campus.getName());
				}
				return "trip/trips";
			}else{
				List<Trip> trips = TripDAO.getAllAvailableTrips();
				req.setAttribute("trips", trips);
			}
		}
		return "trip/trips";
	}
	
	
	@RequestMapping(value = "/auth/create/trip", method = RequestMethod.GET)
	public String tripCreate(HttpServletRequest req) {		//Show the form
		List<Campus> campus_list = CampusDAO.getAllCampus();
		req.setAttribute("campus_list", campus_list);
		return "trip/create";
	}
	
	@RequestMapping(value = "/auth/create/tripRequest", method = RequestMethod.POST)
	public String tripCreateRequest(HttpServletRequest req) {		//Show the form
		try{
			List<Campus> campus_list = CampusDAO.getAllCampus();		//Load campuses in case of error
			req.setAttribute("campus_list", campus_list);
			
			String description = (String) req.getParameter("description");

			int start = Integer.parseInt((String) req.getParameter("campus_start"));
			int end = Integer.parseInt((String) req.getParameter("campus_end"));
			
			String date = (String)req.getParameter("date");
			int hour =  Integer.parseInt((String) req.getParameter("hour"));
			int minute =  Integer.parseInt((String) req.getParameter("minute"));
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			Calendar trip_date = Calendar.getInstance();
			trip_date.setTime(sdf.parse(date));
			trip_date.set(Calendar.HOUR_OF_DAY, hour);
			trip_date.set(Calendar.MINUTE, minute);

			Trip trip = new Trip();
			
			trip.setDescription(description);
			trip.setStart(CampusDAO.getCampusFromId(start));
			trip.setDestination(CampusDAO.getCampusFromId(end));
			trip.setTripDate(trip_date.getTime());
			TripDAO.addTrip(trip);
			return "home";
		}catch(Exception ex){
			req.setAttribute("message", "Server error, please retry");
			return "trip/create";
		}
	}
}
