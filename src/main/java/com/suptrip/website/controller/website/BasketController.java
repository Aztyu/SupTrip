package com.suptrip.website.controller.website;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suptrip.website.dao.BookingDAO;
import com.suptrip.website.dao.CampusDAO;
import com.suptrip.website.entity.Booking;
import com.suptrip.website.entity.Campus;
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

}
