package com.cab.Repositary;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cab.Model.Rolepermissions;
@Repository
public interface RolePermissionsRepo extends JpaRepository<Rolepermissions,Integer>{
	@Query("SELECT r FROM Rolepermissions r WHERE r.RoleID=:roleId")
	List<Rolepermissions> findPages(@Param("roleId") int roleId);
}
