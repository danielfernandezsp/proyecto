package org.iesalixar.dfernandezs.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("index.htm")
    public ModelAndView index(){
        ModelAndView res=new ModelAndView(); 
        return res;
    }       
}