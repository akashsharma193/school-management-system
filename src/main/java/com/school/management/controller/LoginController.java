package com.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.model.LoginResponse;
import com.school.management.model.UserModel;
import com.school.management.service.LoginService;
import com.school.management.util.JwtUtil;

@RestController
public class LoginController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("login")
	public LoginResponse login( @RequestBody UserModel userModel){
		LoginResponse result = new LoginResponse();
		String user = "admin";
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userModel.getEmail(), userModel.getPassword()));
		}catch(Exception e) {
			System.out.println(e);
		}
		UserDetails userData = this.loginService.loadUserByUsername(userModel.getEmail());
		if(userData.getPassword().equals(userModel.getPassword())){
			String token = this.jwtUtil.generateToken(userData);
			result.setAuthToken(token);
			result.setEmailId(userModel.getEmail());
		}
		return result;
	}
	
}
