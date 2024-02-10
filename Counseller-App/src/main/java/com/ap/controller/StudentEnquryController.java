package com.ap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ap.dtos.SearchCriteria;
import com.ap.dtos.StudentEnquryRequest;



@Controller
public class StudentEnquryController {
	
	
	@GetMapping("/enqury")
	public String addEnquryPage(Model model) {
		model.addAttribute("enqury", new StudentEnquryRequest());
		return "enquryView";
	}
	
	@PostMapping("/addenqury")
	public String addEnqury(@RequestBody StudentEnquryRequest studentEnquryRequest,Model model) {
		return null;
	}
	
    @GetMapping("/filter")
	public String filterSerchPage(Model model) {
    	
    	model.addAttribute("serch", new SearchCriteria());
		return "filterPage";
	}
	
    @PostMapping("/serch")
	public String filterSerch(SearchCriteria searchCriteria,Model model) {
    	
		return "filterPage";
	}
	

}
