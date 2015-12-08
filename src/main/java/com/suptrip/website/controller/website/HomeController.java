package com.suptrip.website.controller.website;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.INITIALIZE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suptrip.website.dao.CampusDAO;
import com.suptrip.website.dao.TripDAO;
import com.suptrip.website.dao.UserDAO;
import com.suptrip.website.entity.Campus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		model.addAttribute("users", UserDAO.userNumber());
		model.addAttribute("trips", TripDAO.tripNumber());
		return "index";
	}
	
	@RequestMapping(value = "/auth/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/auth/campus", method = RequestMethod.GET)
	public String campusGet(HttpServletRequest req) {		//Show the form
		return "campus";
	}
	
	@RequestMapping(value = "/auth/campus", method = RequestMethod.POST)
	public String campusPost(HttpServletRequest req) {
		try{
			String name = (String) req.getParameter("name");
			String address = (String) req.getParameter("address");
			String city = (String) req.getParameter("city");
			String postal_code = (String) req.getParameter("postal_code");
			Campus campus = new Campus();
			campus.setName(name);
			campus.setAddress(address);
			campus.setCity(city);
			campus.setPostal_code(Integer.parseInt(postal_code));
			CampusDAO.addCampus(campus);
			req.setAttribute("message", "Campus was created");
			return "redirect:/auth/home";
		}catch(Exception ex){
			req.setAttribute("message", ex.getMessage());
			return "redirect:/auth/home";
		}
	}
	
}
