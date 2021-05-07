package com.school.management.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {

	private String authToken;
	private String userId;
	private String firstName;
	private String LastName;
	private String emailId;
	RoleModel roleModel;
}
