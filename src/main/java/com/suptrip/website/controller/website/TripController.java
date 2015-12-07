package com.suptrip.website.controller.website;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
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
		List<Trip> trips = TripDAO.getAllAvailableTrips();
		if(trips.size() > 15){
			req.setAttribute("trips", trips.subList(0, 15));
		}else{
			req.setAttribute("trips", trips);
		}
		return "trip/trips";
	}
	
	@RequestMapping(value = "/trips/{page_id}", method = RequestMethod.GET)
	public String tripAtPage(HttpServletRequest req, @PathVariable(value="page_id") final String id) {		//Show the form
		return "trip/trips";
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
