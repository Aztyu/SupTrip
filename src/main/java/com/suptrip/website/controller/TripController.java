package com.suptrip.website.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suptrip.website.dao.TripDAO;

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
	public String tripCreate(HttpServletRequest req, @PathVariable(value="page_id") final String id) {		//Show the form
		return "trip/create";
	}
}
