package com.suptrip.website.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suptrip.website.dao.UserDAO;
import com.suptrip.website.entity.User;

@Controller
public class AccountController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		if(req.getAttribute("booster_id") != null && req.getAttribute("password") != null){	//Login password and username were sent
			User user = UserDAO.getUser((Integer)req.getAttribute("booster_id"), (String)req.getAttribute("password"));
			if(user == null){
				return "login";
			}else{
				HttpSession s = req.getSession();
				s.setAttribute("user", user);
				return "home";
			}
		}else{
			return "login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {

		
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest req) {

		Date date = new Date();

		
		return "register";
	}

}
