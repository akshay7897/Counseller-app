package com.ap.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ap.dtos.CounsellerDashboard;
import com.ap.dtos.CounsellerRequest;
import com.ap.dtos.CounsellerResponse;
import com.ap.dtos.LoginForm;
import com.ap.entity.CounsellerInfo;
import com.ap.repository.CounsellerRepository;
import com.ap.service.CounsellerService;

@Service
public class CounsellerServiceImp implements CounsellerService {
	
	private CounsellerRepository counsellerRepository;
	
	public CounsellerServiceImp(CounsellerRepository counsellerRepository) {
		super();
		this.counsellerRepository = counsellerRepository;
	}

	@Override
	public String saveCounseller(CounsellerRequest counsellerRequest) {
		Optional<CounsellerInfo> findByEmail = counsellerRepository.findByEmail(counsellerRequest.getEmail());
		if(findByEmail.isPresent()) {
			return "Already Email Address Is Present ";
		}
		CounsellerInfo counsellerInfo=new CounsellerInfo();
		BeanUtils.copyProperties(counsellerRequest, counsellerInfo);
		counsellerInfo.setIsactive(Boolean.TRUE);
		CounsellerInfo savedCounsellerInfo = counsellerRepository.save(counsellerInfo);
		if (null!=savedCounsellerInfo.getCounsellerKey())
			return "Record Saved Successfully ...!";
		else
		
		return "Record Not saved..";
	}

	@Override
	public CounsellerResponse login(LoginForm loginForm) {
		CounsellerResponse counsellerResponse=new CounsellerResponse();
		Optional<CounsellerInfo> findByEmailAndPassword = counsellerRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
		if(findByEmailAndPassword.isPresent()) {
			BeanUtils.copyProperties(findByEmailAndPassword.get(), counsellerResponse);
		}
		return counsellerResponse;
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
