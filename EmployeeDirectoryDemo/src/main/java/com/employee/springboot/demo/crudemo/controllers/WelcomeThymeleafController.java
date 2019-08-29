package com.employee.springboot.demo.crudemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeThymeleafController {

	/*
	//Display welcome message for the application
	@GetMapping("/")
	public String welcome(Model model) {
		
		model.addAttribute("currentDate", new java.util.Date());
		
		/*Spring will auto-configure to use Thymeleaf hence look for helloworld template
		 *  in src/main/resources/templates/welcome.html
		 *//*
		return "welcome";
		
	}*/
}
