package com.cab.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactModel {
	private Long id;
    private String fullname;
    private String email;
    private String message;
    private String mobile;
}
