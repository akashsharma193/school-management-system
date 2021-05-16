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

import com.school.management.model.ClassModel;
import com.school.management.model.ErrorParameter;
import com.school.management.model.FilterParameter;
import com.school.management.model.ResponseOperationResult;
import com.school.management.service.ClassService;

@RestController
@RequestMapping("class")
public class ClassController {

	@Autowired
	ClassService classService;
	
	@GetMapping("getClassList")
	public ResponseOperationResult<List<ClassModel>> getSubjectList(HttpServletRequest request, @BeanParam FilterParameter filterParameter){
		ResponseOperationResult<List<ClassModel>> result = null;
		
		try {
			result = classService.getSubjectList(filterParameter);
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
	public ResponseOperationResult<ClassModel> createOrUpdate(HttpServletRequest request, @RequestBody ClassModel classModel){
		ResponseOperationResult<ClassModel> result = new ResponseOperationResult<ClassModel>();
		String user = "admin";
		if(request.getUserPrincipal()!=null) {
			user = request.getUserPrincipal().getName();
		}
		try {
			result = classService.createOrUpdate(classModel, user);
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
