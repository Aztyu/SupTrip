package com.suptrip.website.controller.api;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.suptrip.website.dao.CampusDAO;
import com.suptrip.website.dao.TripDAO;
import com.suptrip.website.dao.UserDAO;
import com.suptrip.website.entity.Campus;
import com.suptrip.website.entity.Trip;
import com.suptrip.website.entity.User;

@Controller
public class ApiTripController {
	@RequestMapping(value = "api", method = RequestMethod.GET)
	public String helpPage(HttpServletRequest req) {		//Show the form
		return "api/help";
	}
	
	@RequestMapping(value = "api/trips", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String trips(HttpServletRequest req) {		//Show the form
		List<Trip> trips = TripDAO.getAllTrips();
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		mapper.setDateFormat(format);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(trips);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonList;
	}
	
	@RequestMapping(value = "api/campuses", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String campuses(HttpServletRequest req) {		//Show the form
		List<Campus> campuses = CampusDAO.getAllCampus();
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		mapper.setDateFormat(format);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(campuses);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonList;
	}
	
	@RequestMapping(value = "api/trips/{campus_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String tripsByCampus(HttpServletRequest req,  @PathVariable(value="campus_id") final int campus_id) {		//Show the form
		List<Trip> trips = TripDAO.getTripsByCampusId(campus_id);
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		mapper.setDateFormat(format);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(trips);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonList;
	}
}
