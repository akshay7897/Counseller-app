package com.ap.service;

import java.util.List;

import com.ap.dtos.SearchCriteria;
import com.ap.dtos.StudentEnquryRequest;
import com.ap.dtos.StudentEnquryResponse;

import jakarta.servlet.http.HttpServletRequest;

public interface StudentService {
	
	boolean addStudentEnquries(StudentEnquryRequest studentEnquryRequest,HttpServletRequest request);
	
	List<StudentEnquryResponse> fetchAllEnquries(SearchCriteria searchCriteria);

}
