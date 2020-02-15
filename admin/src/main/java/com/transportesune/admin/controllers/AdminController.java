package com.transportesune.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.transportesune.admin.entities.Transport;
import com.transportesune.admin.services.TransportService;



@Controller
public class AdminController {
	
	@Autowired
	private TransportService transportService;
	
	@GetMapping("/")
	public String admin(Model model) {	
		model.addAttribute("services", transportService.listServices());
		return "admin";
	}
	
	@GetMapping("/addservice")
	public String addservice(Model model) {		
		model.addAttribute("service", new Transport());
		
		return "addservice";
	}
	
	@PostMapping("/save")
	public String save(Transport service) {
		transportService.saveService(service);
		
		return "redirect:" + "/";
	}
	

}
