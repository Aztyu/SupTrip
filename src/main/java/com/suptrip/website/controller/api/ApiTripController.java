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
import com.suptrip.website.dao.TripDAO;
import com.suptrip.website.dao.UserDAO;
import com.suptrip.website.entity.Trip;
import com.suptrip.website.entity.User;

@Controller
public class ApiTripController {
	
	@RequestMapping(value = "api/trips", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String tripAtPage(HttpServletRequest req) {		//Show the form
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
}
