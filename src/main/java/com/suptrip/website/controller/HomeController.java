package com.suptrip.website.controller;

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
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/campus", method = RequestMethod.GET)
	public String campusGet(HttpServletRequest req) {
		try{
			String name;
			if((name = (String) req.getAttribute("name")) != null){
				String address = (String) req.getAttribute("address");
				String city = (String) req.getAttribute("city");
				String postal_code = (String) req.getAttribute("postal_code");
				Campus campus = new Campus();
				campus.setAddress(address);
				campus.setCity(city);
				campus.setPostal_code(Integer.parseInt(postal_code));
				UserDAO.addCampus(campus);
				req.setAttribute("message", "Campus was created");
				return "campus";
			}else{
				return "campus";
			}
		}catch(Exception ex){
			req.setAttribute("message", ex.getMessage());
			return "campus";
		}
	}
	
	@RequestMapping(value = "/campus", method = RequestMethod.POST)
	public String campusPost(HttpServletRequest req) {
		try{
			String name;
			if((name = (String) req.getParameter("name")) != null){
				String address = (String) req.getParameter("address");
				String city = (String) req.getParameter("city");
				String postal_code = (String) req.getParameter("postal_code");
				Campus campus = new Campus();
				campus.setName(name);
				campus.setAddress(address);
				campus.setCity(city);
				campus.setPostal_code(Integer.parseInt(postal_code));
				UserDAO.addCampus(campus);
				req.setAttribute("message", "Campus was created");
				return "campus";
			}else{
				return "campus";
			}
		}catch(Exception ex){
			req.setAttribute("message", ex.getMessage());
			return "campus";
		}
	}
	
}
