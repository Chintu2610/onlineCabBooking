package com.cab.Service;

import java.util.List;

import com.cab.Model.Rolepermissions;

public interface RolePermissionsService {
	List<Rolepermissions> getRolePermissions(String role);
	
}
