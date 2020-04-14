package org.iesalixar.dfernandezs.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/private/eventCreator")
	public String eventCreator() {
		return "private/eventCreator";
	
	}
}
	