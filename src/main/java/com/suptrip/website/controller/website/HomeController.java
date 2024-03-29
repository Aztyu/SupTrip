package com.suptrip.website.controller.website;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
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
import com.suptrip.website.entity.User;

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
	public String home(HttpServletRequest req) {
		List<Campus> campus_list = CampusDAO.getAllCampus();		//Load campuses in case of error
		req.setAttribute("campus_list", campus_list);
		
		return "home";
	}
	
	@RequestMapping(value = "/auth/home", method = RequestMethod.POST)
	public String homePost(HttpServletRequest req) {		//Show the form
		List<Campus> campus_list = CampusDAO.getAllCampus();		//Load campuses in case of error
		req.setAttribute("campus_list", campus_list);
		
		try{
			String firstname = (String) req.getParameter("firstname");
			String lastname = (String) req.getParameter("lastname");
			String email = (String) req.getParameter("email");
			String password = (String) req.getParameter("password");
			String password_verif = (String) req.getParameter("password_v");
			if(password.equals(password_verif)){
				int campus_id = Integer.parseInt(req.getParameter("campus")); 
				
				User user = (User) req.getSession().getAttribute("user");
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setEmail(email);
				user.setPassword(password);
				
				Campus campus = CampusDAO.getCampusFromId(campus_id);
				user.setCampus(campus);
				
				UserDAO.updateUser(user);
				req.getSession().setAttribute("user", user);
				return "redirect:/auth/home";
			}else{
				return "redirect:/auth/home";
			}
		}catch(Exception ex){
			return "auth/home";
		}
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
