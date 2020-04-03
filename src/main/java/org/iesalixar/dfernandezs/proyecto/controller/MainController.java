package org.iesalixar.dfernandezs.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

//	@RequestMapping("index.htm")
//    public ModelAndView index(){
//        ModelAndView res=new ModelAndView(); 
//        return res;
//    }
	
	@GetMapping({"/"})
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/login.htm")
    public ModelAndView login(){
        ModelAndView res=new ModelAndView(); 
        return res;
    }
	
	@GetMapping("/private/eventCreator")
    public ModelAndView priv(){
        ModelAndView res=new ModelAndView(); 
        return res;
    }
}