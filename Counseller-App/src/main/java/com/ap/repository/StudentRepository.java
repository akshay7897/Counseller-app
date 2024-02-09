package com.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
