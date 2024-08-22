package com.cab.Repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cab.Model.CurrentUserSession;
import com.cab.Model.Driver;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession , Integer>{

	
	Optional<CurrentUserSession> findByUuid(String uuid);
	
	@Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid AND c.currRole='Admin'")
	Optional<CurrentUserSession> findByUuidAndRoleAdmin(@Param("uuid") String uuid);
	
	@Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid AND c.currRole = 'Customer'")
	Optional<CurrentUserSession> findByUuidAndRoleCustomer(@Param("uuid") String uuid);
	
	@Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid AND c.currRole = 'Vendor'")
	Optional<CurrentUserSession> findByUuidAndRoleVendor(@Param("uuid") String uuid);
	
}
