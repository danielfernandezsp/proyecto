package org.iesalixar.dfernandezs.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("index.htm")
    public ModelAndView index(){
        ModelAndView res=new ModelAndView();
//        String consulta="select * from cliente";
//        List datos    =this.template.queryForList(consulta);
//        ArrayList<String> paraEnviar=new ArrayList();
       
        return res;
    }       
}