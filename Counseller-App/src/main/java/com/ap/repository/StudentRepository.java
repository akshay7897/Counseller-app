package com.ap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.entity.CounsellerInfo;
import com.ap.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	
	Optional<List<Student>> findByCounsellerKey(CounsellerInfo counsellerKey);

}
