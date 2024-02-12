package com.ap.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.dtos.CounsellerDashboard;
import com.ap.dtos.CounsellerRequest;
import com.ap.dtos.CounsellerResponse;
import com.ap.dtos.LoginForm;
import com.ap.entity.CounsellerInfo;
import com.ap.entity.Student;
import com.ap.repository.CounsellerRepository;
import com.ap.repository.StudentRepository;
import com.ap.service.CounsellerService;
import com.ap.util.EmailUtils;

import jakarta.mail.MessagingException;

@Service
public class CounsellerServiceImp implements CounsellerService {
	
	private CounsellerRepository counsellerRepository;
	
	private StudentRepository studentRepository;
	
	private EmailUtils emailUtils;
	
	public CounsellerServiceImp(CounsellerRepository counsellerRepository,StudentRepository studentRepository,EmailUtils emailUtils) {
		super();
		this.counsellerRepository = counsellerRepository;
		this.studentRepository=studentRepository;
		this.emailUtils=emailUtils;
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
		
		Optional<CounsellerInfo> emailDetails = counsellerRepository.findByEmail(email);
		if(emailDetails.isPresent()) {
			CounsellerInfo counsellerInfo = emailDetails.get();
			
			String subject="Recover your password";
			String body="<h1>Your password is </h1> - "+counsellerInfo.getPassword();
			String to=counsellerInfo.getEmail();
			
			try {
				emailUtils.sendEmail(subject, body, to);
			} catch (MessagingException e) {
				
				e.printStackTrace();
			}
			return true;
		}
		
		return false;
	}

	@Override
	public CounsellerDashboard fetchCounsellerDetails(Long counsellerKey) {
		
		Optional<List<Student>> findByCounsellerKey=null;
		Optional<CounsellerInfo> counsellerInfo = counsellerRepository.findById(counsellerKey);
		if(counsellerInfo.isPresent()) {
			 findByCounsellerKey = studentRepository.findByCounsellerKey(counsellerInfo.get());
		}
		
		List<Student> studentList = findByCounsellerKey.get();
		int total=studentList.size();
		int inrolled = studentList.stream().filter(e->e.getStatus().equals("Enrolled")).toList().size();
		int lost = studentList.stream().filter(e->e.getStatus().equals("Lost")).toList().size();
		
		CounsellerDashboard counsellerDashboard=new CounsellerDashboard();
		counsellerDashboard.setEnrolledCount(inrolled);
		counsellerDashboard.setLostCount(lost);
		counsellerDashboard.setTotal(total);
		
		return counsellerDashboard;
	}

}
