package com.cab.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rolepermissions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int RolePermissionID;
	private int RoleID;
	private String  ModuleName;
	private String FormName;
	private String PermissionType;
	private String DisplayName;
}
