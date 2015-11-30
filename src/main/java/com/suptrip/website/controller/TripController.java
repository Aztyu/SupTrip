package com.suptrip.website.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suptrip.website.dao.CampusDAO;
import com.suptrip.website.dao.TripDAO;
import com.suptrip.website.entity.Campus;
import com.suptrip.website.entity.Trip;

@Controller
public class TripController {
	@RequestMapping(value = "/trips", method = RequestMethod.GET)
	public String trip(HttpServletRequest req) {		//Show the form
		req.setAttribute("trips", TripDAO.getAllTrips().subList(0, 15));
		return "trips";
	}
	
	@RequestMapping(value = "/trips/{page_id}", method = RequestMethod.GET)
	public String tripAtPage(HttpServletRequest req, @PathVariable(value="page_id") final String id) {		//Show the form
		return "trips";
	}
	
	@RequestMapping(value = "/create/trip", method = RequestMethod.GET)
	public String tripCreate(HttpServletRequest req) {		//Show the form
		List<Campus> campus_list = CampusDAO.getAllCampus();
		req.setAttribute("campus_list", campus_list);
		return "trip/create";
	}
	
	@RequestMapping(value = "/create/tripRequest", method = RequestMethod.POST)
	public String tripCreateRequest(HttpServletRequest req) {		//Show the form
		try{
			List<Campus> campus_list = CampusDAO.getAllCampus();		//Load campuses in case of error
			req.setAttribute("campus_list", campus_list);
			
			String description = (String) req.getParameter("description");

			int start = Integer.parseInt((String) req.getParameter("campus_start"));
			int end = Integer.parseInt((String) req.getParameter("campus_end"));
			
			Trip trip = new Trip();
			
			trip.setDescription(description);
			trip.setStart(CampusDAO.getCampusFromId(start));
			trip.setDestination(CampusDAO.getCampusFromId(end));
			trip.setDateCreated(new Date());
			
			TripDAO.addTrip(trip);
			return "redirect:home";
		}catch(Exception ex){
			req.setAttribute("message", "Server error, please retry");
			return "trip/create";
		}
	}
}
