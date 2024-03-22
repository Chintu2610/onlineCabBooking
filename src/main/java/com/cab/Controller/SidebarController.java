package com.cab.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Exception.AdminException;
import com.cab.Model.Rolepermissions;
import com.cab.Service.RolePermissionsService;

@CrossOrigin
@RestController()
@RequestMapping("/sidebar")
public class SidebarController {
	@Autowired
	private RolePermissionsService sidebarService;
	@GetMapping("/customer")
	public ResponseEntity<List<Rolepermissions>> getRolePermission(@RequestParam String role) throws AdminException{
		return new ResponseEntity<List<Rolepermissions>>(sidebarService.getRolePermissions(role),HttpStatus.CREATED);
	}
}
