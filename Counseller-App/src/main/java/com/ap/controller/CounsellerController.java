package com.ap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ap.dtos.CounsellerRequest;
import com.ap.dtos.CounsellerResponse;
import com.ap.dtos.LoginForm;
import com.ap.service.CounsellerService;

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
		return "loginView";
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm, Model model) {
		logger.info("Start login method .");
		CounsellerResponse response = counsellerService.login(loginForm);
		if (!ObjectUtils.isEmpty(response)) {
			model.addAttribute("msg", "Login Successfully");

			logger.info("End login method with dashboard..");
			return "redirect:dashboard";
		}
		model.addAttribute("msg", "Invalid Credentials..");
		logger.info("End login method with invalid credentials.");
		return "loginView";
	}

	@GetMapping("/register")
	public String counsellerRegistrationPage(Model model) {
		logger.info("Start counsellerRegistrationPage method .");

		model.addAttribute("counsellerInfo", new CounsellerRequest());
		
		logger.info("Start counsellerRegistrationPage method .");
		return "counsellerVeiw";
	}

	@PostMapping("/register")
	public String counsellerRegistration(@RequestBody CounsellerRequest counsellerRequest, Model model) {
		logger.info("Start counsellerRegistration method with Request :{}",counsellerRequest);

		boolean savedcounseller = counsellerService.saveCounseller(counsellerRequest);
		if (savedcounseller) {
			model.addAttribute("msg", "Counseller Registered Successfully..");

		} else {
			model.addAttribute("msg", "Counseller Registration Failed...");
		}
		logger.info("end counsellerRegistration method with Response :{}",savedcounseller);
		return "counsellerVeiw";
	}

	@GetMapping("/forgotpassword")
	public String forgotPasswordPage(Model model) {
		logger.info("Start forgotPasswordPage method .");
		return "forgotPasswordView";
	}

	@PostMapping("/forgotpassword")
	public String forgotPassword(@RequestParam String email, Model model) {
		logger.info("Start forgotPassword method with email :{}",email);

		boolean status = counsellerService.forgotPassword(email);
		if (status) {
			model.addAttribute("msg", "Password Sent To Email ID Plz Check..");
		} else {
			model.addAttribute("msg", "Provided Email Is Invalid..");
		}
		logger.info("End forgotPassword method with email :{}",email);
		return "forgotPasswordView";
	}

}
