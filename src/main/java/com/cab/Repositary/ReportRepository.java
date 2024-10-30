package com.cab.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cab.Model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{
	@Query(value="select * from report where customer_id=:currUserId",nativeQuery=true)
	List<Report> findBycustomerId(@Param("currUserId") Integer currUserId);
	@Query(value="select * from report where driver_id=:currUserId",nativeQuery=true)
	List<Report> findByDriverId(Integer currUserId);
	@Query(value="select r.* from report r inner join driver d on r.driver_id=d.driver_id  where d.owner_email=:email",nativeQuery=true)
	List<Report> findByVendor(@Param("email") String email);
	
}
