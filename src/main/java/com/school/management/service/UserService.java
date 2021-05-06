package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.school.management.Repo.UserRepo;
import com.school.management.common.CreatePagination;
import com.school.management.entity.User;
import com.school.management.model.FilterParameter;
import com.school.management.model.PageAttribute;
import com.school.management.model.ResponseOperationResult;
import com.school.management.model.UserModel;
import com.school.management.util.FilterUtil;
import com.school.management.util.SearchCriteria;
import com.school.management.util.SearchOperation;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepo userRepo;

	public ResponseOperationResult<List<UserModel>> getUserList(FilterParameter filterParameter) {
		ResponseOperationResult<List<UserModel>> response = new ResponseOperationResult<>();
		response.setResponse(new ArrayList<UserModel>());
		
		List<UserModel> userModelList = new ArrayList();
		String id = filterParameter.getId();
		String firstName = filterParameter.getFirstName();
		String lastName = filterParameter.getLastName();
		String isActive = filterParameter.getIsActive();
		Integer from = filterParameter.getPageIndex();
		Integer to = filterParameter.getRecordToShowOnOnePage();
		
		Integer recordToShowOnPage = filterParameter.getRecordToShowOnOnePage() == 0 ? 25 : filterParameter.getRecordToShowOnOnePage();
		
		List<SearchCriteria> list = new ArrayList<>();
		SearchCriteria sc = new SearchCriteria();
		if (!StringUtils.isEmpty(id)) {
			sc = new SearchCriteria("id", id, SearchOperation.EQUAL);
			list.add(sc);
		}
		if (!StringUtils.isEmpty(firstName)) {
			sc = new SearchCriteria("firstName", firstName, SearchOperation.EQUAL);
			list.add(sc);
		}
		if (!StringUtils.isEmpty(lastName)) {
			sc = new SearchCriteria("lastName", lastName, SearchOperation.EQUAL);
			list.add(sc);
		}
		if (!StringUtils.isEmpty(isActive)) {
			sc = new SearchCriteria("isActive", isActive, SearchOperation.EQUAL);
			list.add(sc);
		}
		FilterUtil<User> filterUtil = new FilterUtil<User>();

		List<User> userData = new ArrayList<User>();
		Long recordTotal = (long) 0;
		if(from!=null && to!=null) {
			Pageable page = PageRequest.of(from, to);
			userData = userRepo.findAll(filterUtil.getSpecification(list), page).getContent();
		}else {
			userData = userRepo.findAll(filterUtil.getSpecification(list));
		}
		if (userData != null && !userData.isEmpty()) {
			recordTotal = (long) userData.size();
			for (User user : userData) {
				UserModel userModel = new UserModel();
				entityToModel(userModel, user);
				userModelList.add(userModel);
			}
		}
		response.setPageAttribute(CreatePagination.pagination(filterParameter, recordTotal, recordToShowOnPage));
		response.setResponse(userModelList);
		
		return response;
	}
	
	private void entityToModel(UserModel userModel ,User userEntity) {
		userModel.setId(userEntity.getId()!=null ? userEntity.getId() : userModel.getId());
		userModel.setFirstName(userEntity.getFirstName()!=null ? userEntity.getFirstName() : userModel.getFirstName());
		userModel.setMiddleName(userEntity.getMiddleName()!=null ? userEntity.getMiddleName() : userModel.getMiddleName());
		userModel.setLastName(userEntity.getLastName()!=null ? userEntity.getLastName() : userModel.getLastName());
		userModel.setAddress(userEntity.getAddress()!=null ? userEntity.getAddress() : userModel.getAddress());
		userModel.setIsActive(userEntity.getIsActive()!=null ? userEntity.getIsActive() : userModel.getIsActive());
	}
	
	private void modelToEntity(UserModel userModel ,User userEntity) {
		userEntity.setId(userModel.getId()!=null ? userModel.getId() : userEntity.getId());
		userEntity.setFirstName(userModel.getFirstName()!=null ? userModel.getFirstName() : userEntity.getFirstName());
		userEntity.setMiddleName(userModel.getMiddleName()!=null ? userModel.getMiddleName() : userEntity.getMiddleName());
		userEntity.setLastName(userModel.getLastName()!=null ? userModel.getLastName() : userEntity.getLastName());
		userEntity.setAddress(userModel.getAddress()!=null ? userModel.getAddress() : userEntity.getAddress());
		userEntity.setIsActive(userModel.getIsActive()!=null ? userModel.getIsActive() : userEntity.getIsActive());
	}
}
