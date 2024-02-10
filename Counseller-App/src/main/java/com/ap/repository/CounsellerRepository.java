package com.ap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.entity.CounsellerInfo;

@Repository
public interface CounsellerRepository extends JpaRepository<CounsellerInfo, Long> {
	
	Optional<CounsellerInfo> findByEmail(String email);
	
	Optional<CounsellerInfo> findByEmailAndPassword(String email,String password);

}
