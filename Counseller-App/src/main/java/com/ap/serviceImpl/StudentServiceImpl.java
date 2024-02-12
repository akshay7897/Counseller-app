package com.ap.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ap.dtos.SearchCriteria;
import com.ap.dtos.StudentEnquryRequest;
import com.ap.dtos.StudentEnquryResponse;
import com.ap.entity.CounsellerInfo;
import com.ap.entity.Student;
import com.ap.repository.CounsellerRepository;
import com.ap.repository.StudentRepository;
import com.ap.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class StudentServiceImpl implements StudentService {
	
	private  StudentRepository studentRepository;
	
	private CounsellerRepository counsellerRepository;

	public StudentServiceImpl(StudentRepository studentRepository, CounsellerRepository counsellerRepository) {
		this.studentRepository = studentRepository;
		this.counsellerRepository = counsellerRepository;
	}

	@Override
	public boolean addStudentEnquries(StudentEnquryRequest studentEnquryRequest,HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		Long consellerKey=(Long)session.getAttribute("cid");
		
		boolean isSaved=false;
		
		Student student=new Student();
		BeanUtils.copyProperties(studentEnquryRequest, student);
		student.setIsactive(Boolean.TRUE);
		Optional<CounsellerInfo> counsellerKey = counsellerRepository.findById(consellerKey);
		if(counsellerKey.isPresent())
			student.setCounsellerKey(counsellerKey.get());
		try {
		studentRepository.save(student);
		isSaved=true;
		}catch (Exception e) {
			throw new RuntimeException("Student enquiry not added");
		}
		return isSaved;
		
	}

	@Override
	public List<StudentEnquryResponse> fetchAllEnquries(SearchCriteria searchCriteria) {
		return null;
	}

}
