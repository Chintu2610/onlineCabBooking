package com.cab.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.Model.Rolepermissions;
import com.cab.Repositary.RolePermissionsRepo;
@Service
public class RolePermissionsServiceImpl implements RolePermissionsService{
	@Autowired
	RolePermissionsRepo repo;

	@Override
	public List<Rolepermissions> getRolePermissions(String role) {
		// TODO Auto-generated method stub
		int roleId=1;
		if(role.equals("Admin"))
		{
			roleId=2;
		}
		return repo.findPages(roleId);
		
	}
	
}
