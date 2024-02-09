package com.ap.service;

import java.util.List;

import com.ap.dtos.SearchCriteria;
import com.ap.dtos.StudentEnquryRequest;
import com.ap.dtos.StudentEnquryResponse;
import com.ap.entity.CounsellerInfo;

public interface StudentService {
	
	boolean addStudentEnquries(StudentEnquryRequest studentEnquryRequest);
	
	List<StudentEnquryResponse> fetchAllEnquries(SearchCriteria searchCriteria,CounsellerInfo counsellerKey);

}
