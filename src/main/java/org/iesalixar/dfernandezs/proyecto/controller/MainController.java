package org.iesalixar.dfernandezs.proyecto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.dfernandezs.proyecto.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	
	@Autowired
	private EventRepository eventRepository;

	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}

	@GetMapping("/events")
	public String events(Model model) {
		model.addAttribute("events", eventRepository.findAll());
		return "events";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/private/eventCreator")
	public String eventCreator2() {
		return "private/eventCreator";
	
	}
}
	