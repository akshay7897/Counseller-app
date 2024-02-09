package com.ap.serviceImpl;

import org.springframework.stereotype.Service;

import com.ap.dtos.CounsellerDashboard;
import com.ap.dtos.CounsellerRequest;
import com.ap.dtos.CounsellerResponse;
import com.ap.dtos.LoginForm;
import com.ap.service.CounsellerService;

@Service
public class CounsellerServiceImp implements CounsellerService {

	@Override
	public boolean saveCounseller(CounsellerRequest counsellerRequest) {
		return false;
	}

	@Override
	public CounsellerResponse login(LoginForm loginForm) {
		return null;
	}

	@Override
	public boolean forgotPassword(String email) {
		return false;
	}

	@Override
	public CounsellerDashboard fetchCounsellerDetails(Long counsellerKey) {
		return null;
	}

}
