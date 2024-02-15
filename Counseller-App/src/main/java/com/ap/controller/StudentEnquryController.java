package com.ap.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ap.dtos.SearchCriteria;
import com.ap.dtos.StudentEnquryRequest;
import com.ap.dtos.StudentEnquryResponse;
import com.ap.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentEnquryController {
	
	private StudentService studentService;
	
	public StudentEnquryController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/enqury")
	public String addEnquryPage(Model model) {
		model.addAttribute("enquiry", new StudentEnquryRequest());
		return "enquryView";
	}
	
	@PostMapping("/enqury")
	public String addEnqury(StudentEnquryRequest studentEnquryRequest,HttpServletRequest request,Model model) {
		boolean addStudentEnquries = studentService.addStudentEnquries(studentEnquryRequest,request);
		if(addStudentEnquries) {
			model.addAttribute("msg", "Student Enqury Added Successfully .");
			
		}else {
		model.addAttribute("msg", "Student Enqury Not Added .");
		}
		model.addAttribute("enquiry", new StudentEnquryRequest());
		return "enquryView";
	}
	
    @GetMapping("/filter")
	public String filterSerchPage(Model model,HttpServletRequest request) {
    	List<StudentEnquryResponse> allEnquries = studentService.fetchAllEnquries(request);
    	model.addAttribute("allEnquries", allEnquries);
    	model.addAttribute("serch", new SearchCriteria());
		return "filterPage";
	}
	
    @PostMapping("/serch")
	public String filterSerch(SearchCriteria searchCriteria,Model model,HttpServletRequest request) {
    	List<StudentEnquryResponse> allEnquries = studentService.fetchAllEnquries(searchCriteria,request);
    	model.addAttribute("serch", new SearchCriteria());
    	model.addAttribute("allEnquries", allEnquries);
		return "filterPage";
	}
	

}
