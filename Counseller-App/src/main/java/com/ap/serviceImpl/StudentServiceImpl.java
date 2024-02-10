package com.ap.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ap.dtos.SearchCriteria;
import com.ap.dtos.StudentEnquryRequest;
import com.ap.dtos.StudentEnquryResponse;
import com.ap.entity.CounsellerInfo;
import com.ap.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public boolean addStudentEnquries(StudentEnquryRequest studentEnquryRequest) {
		return false;
	}

	@Override
	public List<StudentEnquryResponse> fetchAllEnquries(SearchCriteria searchCriteria, CounsellerInfo counsellerKey) {
		return null;
	}

}
