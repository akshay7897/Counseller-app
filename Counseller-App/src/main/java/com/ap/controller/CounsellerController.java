package com.ap.controller;

import org.springframework.stereotype.Controller;

import com.ap.dtos.CounsellerRequest;
import com.ap.dtos.LoginForm;

import ch.qos.logback.core.model.Model;

@Controller
public class CounsellerController {
	
	public String indexPage(Model model) {
		return null;
	}
	
	public String counsellerRegistrationPage(Model model) {
		return null;
	}
	
	
	public String forgotPasswordPage(Model model) {
		return null;
	}
	
	
	public String login(LoginForm loginForm,Model model) {
		return null;
	}
	
	public String counsellerRegistration(CounsellerRequest counsellerRequest,Model model) {
		return null;
	}
	
	public String forgotPassword(String email,Model model) {
		return null;
	}
	

}
