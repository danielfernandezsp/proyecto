package org.iesalixar.dfernandezs.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	@RequestMapping("/index")
	public String welcome() {
		return "index";
	}
}