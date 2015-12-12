package com.suptrip.website.controller.website;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suptrip.website.dao.BookingDAO;
import com.suptrip.website.dao.CampusDAO;
import com.suptrip.website.dao.TripDAO;
import com.suptrip.website.entity.Booking;
import com.suptrip.website.entity.Campus;
import com.suptrip.website.entity.Trip;
import com.suptrip.website.entity.User;

@Controller
public class BasketController {
	@RequestMapping(value = "/auth/basket", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<Booking> booked = BookingDAO.getBookingsFromId(user.getBooster_id());		//Load campuses in case of error
		req.setAttribute("booked_trips", booked);		//Trips already accepted by user
		
		return "basket/basket";
	}
	
	@RequestMapping(value = "auth/book/{trip_id}", method = RequestMethod.GET)
	public String tripAddToBasket(HttpServletRequest req, @PathVariable(value="trip_id") final int trip_id) {		//Show the form
		Trip t = TripDAO.getTripById(trip_id);
		if(t != null){
			HttpSession session = req.getSession();
			Booking book = new Booking();
			book.setTrip_booked(t);
			book.setUser((User) session.getAttribute("user"));
			
			List<Booking> ses_booking = (List<Booking>) session.getAttribute("booking"); 
			if(ses_booking == null){
				ses_booking = new ArrayList<Booking>();
			}
			ses_booking.add(book);
			session.setAttribute("booking", ses_booking);
		}
		return "redirect:/auth/trips";
	}

}
