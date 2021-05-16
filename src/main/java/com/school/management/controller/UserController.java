package com.school.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.model.ErrorParameter;
import com.school.management.model.FilterParameter;
import com.school.management.model.LoginResponse;
import com.school.management.model.ResponseOperationResult;
import com.school.management.model.UserModel;
import com.school.management.service.UserService;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("User")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("getUserList")
	public ResponseOperationResult<List<UserModel>> getUserList(HttpServletRequest request, @BeanParam FilterParameter filterParameter){
		ResponseOperationResult<List<UserModel>> result = null;
		try {
			result = userService.getUserList(filterParameter);
		}catch(Exception e) {
			result = new ResponseOperationResult<>();
			ErrorParameter error = new ErrorParameter();
			error.setErrorCode("noCode");
			error.setErrorDiscription(e.getMessage());
			result.setErrorParameter(error);
		}
		return result;
	}
	
	@PostMapping("createOrUpdate")
	public ResponseOperationResult<UserModel> createOrUpdate(HttpServletRequest request, @RequestBody UserModel userModel){
		ResponseOperationResult<UserModel> result = new ResponseOperationResult<UserModel>();
		String user = "admin";
		if(request.getUserPrincipal()!=null) {
			user = request.getUserPrincipal().getName();
		}
		try {
			result = userService.createOrUpdate(userModel, user);
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
