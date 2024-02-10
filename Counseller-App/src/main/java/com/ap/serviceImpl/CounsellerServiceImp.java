package com.ap.serviceImpl;

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
	public boolean saveCounseller(CounsellerRequest counsellerRequest) {
		CounsellerInfo counsellerInfo=new CounsellerInfo();
		boolean isSaved=false;
		BeanUtils.copyProperties(counsellerRequest, counsellerInfo);
		counsellerInfo.setIsactive(Boolean.TRUE);
		
		CounsellerInfo savedCounsellerInfo = counsellerRepository.save(counsellerInfo);
		if (null!=savedCounsellerInfo.getCounsellerKey())
			isSaved=true;
		
		return isSaved;
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
