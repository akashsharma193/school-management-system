package com.school.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.school.management.Repo.UserRepo;
import com.school.management.common.CreatePagination;
import com.school.management.entity.Role;
import com.school.management.entity.User;
import com.school.management.model.FilterParameter;
import com.school.management.model.LoginResponse;
import com.school.management.model.ResponseOperationResult;
import com.school.management.model.RoleModel;
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

		Integer recordToShowOnPage = filterParameter.getRecordToShowOnOnePage() == 0 ? 25
				: filterParameter.getRecordToShowOnOnePage();

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
		if (from != null && to != null) {
			Pageable page = PageRequest.of(from, to);
			userData = userRepo.findAll(filterUtil.getSpecification(list), page).getContent();
		} else {
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

	public ResponseOperationResult<UserModel> createOrUpdate(UserModel userModel, String user) {
		ResponseOperationResult<UserModel> response = new ResponseOperationResult<>();
		try {
			Integer id = userModel.getId() == null ? null : userModel.getId();

			if (id != null) {
				User userData = userRepo.findById(id).get();
				modelToEntity(userModel, userData);
				userData.setUpdateDate(new Date());
				userData.setUpdatedBy(user);
				userRepo.save(userData);
			} else {
				User userData = new User();
				modelToEntity(userModel, userData);
				userData.setCraeateDate(new Date());
				userData.setCreatedBy(user);
				userData.setIsActive(1);
				userRepo.save(userData);
			}
			response.setResponse(userModel);
		} catch (Exception e) {

		}
		return response;
	}
	
	public LoginResponse login(UserModel userModel, String user, FilterParameter filterParameter) {
		User userData = userRepo.findByEmail(userModel.getEmail());
		LoginResponse response = new LoginResponse();

		if(userData!=null && userData.getPassword()!=null && userModel.getPassword()!=null && userData.getPassword().equals(userModel.getPassword())) {
			response.setAuthToken("");
			response.setEmailId(userData.getEmail());
			response.setFirstName(userData.getFirstName());
			response.setLastName(userData.getLastName());
			response.setUserId(userData.getId().toString());
			response.setRoleModel(new RoleModel(userData.getRole().getId(), userData.getRole().getRoleName(), userData.getRole().getIsActive()));
		}
		return response;
	}

	private void entityToModel(UserModel userModel, User userEntity) {
		userModel.setId(userEntity.getId() != null ? userEntity.getId() : userModel.getId());
		userModel.setFirstName(userEntity.getFirstName() != null ? userEntity.getFirstName() : userModel.getFirstName());
		userModel.setMiddleName(userEntity.getMiddleName() != null ? userEntity.getMiddleName() : userModel.getMiddleName());
		userModel.setLastName(userEntity.getLastName() != null ? userEntity.getLastName() : userModel.getLastName());
		userModel.setAddress(userEntity.getAddress() != null ? userEntity.getAddress() : userModel.getAddress());
		userModel.setRoleId(userEntity.getRoleId() !=null ? userEntity.getRoleId() : userModel.getRoleId());
		userModel.setRoleModel(new RoleModel(userEntity.getRole().getId(), userEntity.getRole().getRoleName(), userEntity.getRole().getIsActive()));
		//userModel.setPassword(userEntity.getPassword() !=null ? userEntity.getPassword() : userModel.getPassword());
		userModel.setEmail(userEntity.getEmail() !=null ? userEntity.getEmail() : userModel.getEmail());
		userModel.setMobile(userEntity.getMobile() !=null ? userEntity.getMobile() : userModel.getMobile());
		userModel.setAdharNumber(userEntity.getAdharNumber() !=null ? userEntity.getAdharNumber() : userModel.getAdharNumber());
		userModel.setIsAvailableOnWeb(userEntity.getIsAvailableOnWeb() !=null ? userEntity.getIsAvailableOnWeb() : userModel.getIsAvailableOnWeb());
		userModel.setProfilePictureName(userEntity.getProfilePictureName() !=null ? userEntity.getProfilePictureName() : userModel.getProfilePictureName());
		userModel.setProfilePictureData(userEntity.getProfilePictureData() !=null ? userEntity.getProfilePictureData() : userModel.getProfilePictureData());
		userModel.setProfilePicturePath(userEntity.getProfilePicturePath() !=null ? userEntity.getProfilePicturePath() : userModel.getProfilePicturePath());
		userModel.setProfilePictureSize(userEntity.getProfilePictureSize() !=null ? userEntity.getProfilePictureSize() : userModel.getProfilePictureSize());
		userModel.setUpdateDate(userEntity.getUpdateDate() !=null ? userEntity.getUpdateDate() : userModel.getUpdateDate());
		userModel.setUpdatedBy(userEntity.getUpdatedBy() !=null ? userEntity.getUpdatedBy() : userModel.getUpdatedBy());
		userModel.setCreatedBy(userEntity.getCreatedBy() !=null ? userEntity.getCreatedBy() : userModel.getCreatedBy());
		userModel.setCraeateDate(userEntity.getCraeateDate() !=null ? userEntity.getCraeateDate() : userModel.getCraeateDate());
		userModel.setIsActive(userEntity.getIsActive() != null ? userEntity.getIsActive() : userModel.getIsActive());
	
	}

	private void modelToEntity(UserModel userModel, User userEntity) {
		userEntity.setId(userModel.getId() != null ? userModel.getId() : userEntity.getId());
		userEntity.setId(userModel.getId() != null ? userModel.getId() : userEntity.getId());
		userEntity.setFirstName(userModel.getFirstName() != null ? userModel.getFirstName() : userEntity.getFirstName());
		userEntity.setMiddleName(userModel.getMiddleName() != null ? userModel.getMiddleName() : userEntity.getMiddleName());
		userEntity.setLastName(userModel.getLastName() != null ? userModel.getLastName() : userEntity.getLastName());
		userEntity.setAddress(userModel.getAddress() != null ? userModel.getAddress() : userEntity.getAddress());
		userEntity.setRoleId(userModel.getRoleId() !=null ? userModel.getRoleId() : userEntity.getRoleId());
		//userEntity.setRole(new Role(userModel.getRoleModel().getId(), userModel.getRoleModel().getRoleName(), userModel.getRoleModel().getIsActive()));
		userEntity.setPassword(userModel.getPassword() !=null ? userModel.getPassword() : userEntity.getPassword());
		userEntity.setEmail(userModel.getEmail() !=null ? userModel.getEmail() : userEntity.getEmail());
		userEntity.setMobile(userModel.getMobile() !=null ? userModel.getMobile() : userEntity.getMobile());
		userEntity.setAdharNumber(userModel.getAdharNumber() !=null ? userModel.getAdharNumber() : userEntity.getAdharNumber());
		userEntity.setIsAvailableOnWeb(userModel.getIsAvailableOnWeb() !=null ? userModel.getIsAvailableOnWeb() : userEntity.getIsAvailableOnWeb());
		userEntity.setProfilePictureName(userModel.getProfilePictureName() !=null ? userModel.getProfilePictureName() : userEntity.getProfilePictureName());
		userEntity.setProfilePictureData(userModel.getProfilePictureData() !=null ? userModel.getProfilePictureData() : userEntity.getProfilePictureData());
		userEntity.setProfilePicturePath(userModel.getProfilePicturePath() !=null ? userModel.getProfilePicturePath() : userEntity.getProfilePicturePath());
		userEntity.setProfilePictureSize(userModel.getProfilePictureSize() !=null ? userModel.getProfilePictureSize() : userEntity.getProfilePictureSize());
		userEntity.setUpdateDate(userModel.getUpdateDate() !=null ? userModel.getUpdateDate() : userEntity.getUpdateDate());
		userEntity.setUpdatedBy(userModel.getUpdatedBy() !=null ? userModel.getUpdatedBy() : userEntity.getUpdatedBy());
		userEntity.setCreatedBy(userModel.getCreatedBy() !=null ? userModel.getCreatedBy() : userEntity.getCreatedBy());
		userEntity.setCraeateDate(userModel.getCraeateDate() !=null ? userModel.getCraeateDate() : userEntity.getCraeateDate());
		userEntity.setIsActive(userModel.getIsActive() != null ? userModel.getIsActive() : userEntity.getIsActive());
		
	}

	
}
