package com.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.entity.CounsellerInfo;

@Repository
public interface CounsellerRepository extends JpaRepository<CounsellerInfo, Long> {

}
