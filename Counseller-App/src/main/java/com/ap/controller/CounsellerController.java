package com.ap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ap.dtos.CounsellerDashboard;
import com.ap.dtos.CounsellerRequest;
import com.ap.dtos.CounsellerResponse;
import com.ap.dtos.LoginForm;
import com.ap.dtos.SearchCriteria;
import com.ap.service.CounsellerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellerController {

	private static final Logger logger = LoggerFactory.getLogger(CounsellerController.class);

	private CounsellerService counsellerService;

	public CounsellerController(CounsellerService counsellerService) {
		super();
		this.counsellerService = counsellerService;
	}

	@GetMapping("/login")
	public String indexPage(Model model) {
		logger.info("Start indexPage method .");

		model.addAttribute("loginform", new LoginForm());

		logger.info("End indexPage method .");
		return "login";
	}

	@PostMapping("/login")
	public String login(LoginForm loginForm,HttpServletRequest request, Model model) {
		logger.info("Start login method .");
		CounsellerResponse response = counsellerService.login(loginForm);
		if (!ObjectUtils.isEmpty(response)&& null!=response.getEmail()) {
			model.addAttribute("msg", "Login Successfully");
			
			HttpSession session = request.getSession(true);
			session.setAttribute("cid", response.getCounsellerKey());

			logger.info("End login method with dashboard..");
			return "redirect:dashboard";
		}
		model.addAttribute("msg", "Invalid Credentials..");
		model.addAttribute("loginform", new LoginForm());
		logger.info("End login method with invalid credentials.");
		return "login";
	}

	@GetMapping("/register")
	public String counsellerRegistrationPage(Model model) {
		logger.info("Start counsellerRegistrationPage method .");

		model.addAttribute("counseller", new CounsellerRequest());
		
		logger.info("Start counsellerRegistrationPage method .");
		return "registerconseller";
	}

	@PostMapping("/register")
	public String counsellerRegistration(CounsellerRequest counsellerRequest, Model model) {
		logger.info("Start counsellerRegistration method with Request :{}",counsellerRequest);

		String msg = counsellerService.saveCounseller(counsellerRequest);
		model.addAttribute("msg", msg);

		 model.addAttribute("counseller", new CounsellerRequest());
		logger.info("end counsellerRegistration method with Response :{}",msg);
		return "registerconseller";
	}

	@GetMapping("/recoverpassword")
	public String forgotPasswordPage(Model model) {
		logger.info("Start forgotPasswordPage method .");
		return "forgotPasswordView";
	}

	@PostMapping("/recoverpassword")
	public String forgotPassword(@RequestParam String email, Model model) {
		logger.info("Start forgotPassword method with email :{}",email);

		boolean status = counsellerService.forgotPassword(email);
		if (status) {
			model.addAttribute("msg", "Password Sent To Email ID Please Check..");
		} else {
			model.addAttribute("msg", "Provided Email Id Is Invalid..");
		}
		logger.info("End forgotPassword method with email :{}",email);
		return "forgotPasswordView";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession(false);
		Object obj = session.getAttribute("cid");
		Long cid=(Long)obj;
		CounsellerDashboard counsellerDashboard = counsellerService.fetchCounsellerDetails(cid);
		model.addAttribute("counsellerDashboard", counsellerDashboard);
		
		return "dashboardView";
	}
	

}
