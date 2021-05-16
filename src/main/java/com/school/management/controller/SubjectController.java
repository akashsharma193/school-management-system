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
import com.school.management.model.ResponseOperationResult;
import com.school.management.model.SubjectModel;
import com.school.management.model.UserModel;
import com.school.management.service.SubjectService;

@RestController
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@GetMapping("getSubjectList")
	public ResponseOperationResult<List<SubjectModel>> getSubjectList(HttpServletRequest request, @BeanParam FilterParameter filterParameter){
		ResponseOperationResult<List<SubjectModel>> result = null;
		
		try {
			result = subjectService.getSubjectList(filterParameter);
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
	public ResponseOperationResult<SubjectModel> createOrUpdate(HttpServletRequest request, @RequestBody SubjectModel subjectModel){
		ResponseOperationResult<SubjectModel> result = new ResponseOperationResult<SubjectModel>();
		String user = "admin";
		if(request.getUserPrincipal()!=null) {
			user = request.getUserPrincipal().getName();
		}
		try {
			result = subjectService.createOrUpdate(subjectModel, user);
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
