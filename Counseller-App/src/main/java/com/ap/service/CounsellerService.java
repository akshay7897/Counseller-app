package com.ap.service;

import com.ap.dtos.CounsellerDashboard;
import com.ap.dtos.CounsellerRequest;
import com.ap.dtos.CounsellerResponse;
import com.ap.dtos.LoginForm;

public interface CounsellerService {
	
	String saveCounseller(CounsellerRequest counsellerRequest);
	
	CounsellerResponse login(LoginForm loginForm);
	
	boolean forgotPassword(String email);
	
	CounsellerDashboard fetchCounsellerDetails(Long counsellerKey);

}
