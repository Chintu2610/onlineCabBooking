package com.cab.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.Model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{
	
}
