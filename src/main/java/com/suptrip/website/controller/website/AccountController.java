package com.suptrip.website.controller.website;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suptrip.website.dao.CampusDAO;
import com.suptrip.website.dao.UserDAO;
import com.suptrip.website.entity.Campus;
import com.suptrip.website.entity.User;

@Controller
public class AccountController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
	public String loginRequest(HttpServletRequest req) {
		try{
			if(req.getParameter("id") != null && req.getParameter("password") != null){	//Login password and username were sent
				User user = UserDAO.getUser(Integer.parseInt((String)req.getParameter("id")), (String)req.getParameter("password"));
				if(user == null){
					req.setAttribute("message", "User does not exist");
					return "index";
				}else{
					HttpSession s = req.getSession();
					s.setAttribute("user", user);
					return "redirect:auth/home";
				}
			}else{
				req.setAttribute("message", "Please fill in every field");
				return "index";
			}
		}catch(NumberFormatException ex){
			req.setAttribute("message", "Please enter a valid ID Booster");
			return "index";
		}catch(Exception ex){
			req.setAttribute("message", "Server error - Please retry");
			return "index";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		HttpSession s = req.getSession();
		s.removeAttribute("user");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest req) {
		List<Campus> campus_list = CampusDAO.getAllCampus();
		req.setAttribute("campus_list", campus_list);
		return "register";
	}
	
	@RequestMapping(value = "/registerRequest", method = RequestMethod.POST)
	public String registerRequest(HttpServletRequest req) {
		try{
			List<Campus> campus_list = CampusDAO.getAllCampus();		//Load campuses in case of error
			req.setAttribute("campus_list", campus_list);
			
			int id = Integer.parseInt(req.getParameter("id_booster"));
			if(!UserDAO.userExists(id)){
				req.setAttribute("id", id);
				String firstname = (String) req.getParameter("firstname");
				req.setAttribute("firstname", firstname);
				String lastname = (String) req.getParameter("lastname");
				req.setAttribute("lastname", lastname);
				String email = (String) req.getParameter("email");
				req.setAttribute("email", email);
				String password = (String) req.getParameter("password");
				String password_verif = (String) req.getParameter("password_v");
				if(password.equals(password_verif)){
					req.setAttribute("password", password);
					int campus_id = Integer.parseInt(req.getParameter("campus")); 
					
					User user = new User();
					user.setBooster_id(id);
					user.setFirstname(firstname);
					user.setLastname(lastname);
					user.setEmail(email);
					user.setPassword(password);
					
					Campus campus = CampusDAO.getCampusFromId(campus_id);
					user.setCampus(campus);
					
					UserDAO.addUser(user);
					req.getSession().setAttribute("user", user);
					return "redirect:auth/home";
				}else{
					req.setAttribute("message", "Passwords do not match");
					return "register";
				}
			}else{
				req.setAttribute("message", "User is already registered");
				return "register";
			}
		}catch(Exception ex){
			req.setAttribute("message", ex.getMessage());
			return "register";
		}
	}


}
