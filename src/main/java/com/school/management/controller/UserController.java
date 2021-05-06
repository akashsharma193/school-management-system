package com.school.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.model.ErrorParameter;
import com.school.management.model.FilterParameter;
import com.school.management.model.ResponseOperationResult;
import com.school.management.model.UserModel;
import com.school.management.service.UserService;

import org.apache.log4j.Logger;

@RestController
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
}