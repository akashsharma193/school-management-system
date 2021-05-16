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

import com.school.management.Repo.ClassRepo;
import com.school.management.Repo.SubjectRepo;
import com.school.management.common.CreatePagination;
import com.school.management.entity.ClassEntity;
import com.school.management.entity.Subject;
import com.school.management.model.ClassModel;
import com.school.management.model.FilterParameter;
import com.school.management.model.ResponseOperationResult;
import com.school.management.model.SubjectModel;
import com.school.management.util.FilterUtil;
import com.school.management.util.SearchCriteria;
import com.school.management.util.SearchOperation;

@Service
@Transactional
public class ClassService {

	@Autowired
	ClassRepo classRepo;

	public ResponseOperationResult<List<ClassModel>> getSubjectList(FilterParameter filterParameter) {
		ResponseOperationResult<List<ClassModel>> response = new ResponseOperationResult<>();
		response.setResponse(new ArrayList<ClassModel>());

		List<ClassModel> classModelList = new ArrayList();
		String id = filterParameter.getId();
		String className = filterParameter.getClassName();
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
		if (!StringUtils.isEmpty(className)) {
			sc = new SearchCriteria("className", className, SearchOperation.EQUAL);
			list.add(sc);
		}
		if (!StringUtils.isEmpty(isActive)) {
			sc = new SearchCriteria("isActive", isActive, SearchOperation.EQUAL);
			list.add(sc);
		}
		FilterUtil<ClassEntity> filterUtil = new FilterUtil<ClassEntity>();

		List<ClassEntity> classtData = new ArrayList<ClassEntity>();
		Long recordTotal = (long) 0;
		if (from != null && to != null) {
			Pageable page = PageRequest.of(from, to);
			classtData = classRepo.findAll(filterUtil.getSpecification(list), page).getContent();
		} else {
			classtData = classRepo.findAll(filterUtil.getSpecification(list));
		}
		if (classtData != null && !classtData.isEmpty()) {
			recordTotal = (long) classtData.size();
			for (ClassEntity classEnt : classtData) {
				ClassModel classtModel = new ClassModel();
				entityToModel(classtModel, classEnt);
				classModelList.add(classtModel);
			}
		}
		response.setPageAttribute(CreatePagination.pagination(filterParameter, recordTotal, recordToShowOnPage));
		response.setResponse(classModelList);

		return response;
	
		
	}

	private void entityToModel(ClassModel classModel, ClassEntity classEntity) {
		classModel.setId(classEntity.getClasssId()!=null ? classEntity.getClasssId() : classModel.getId()); 
		classModel.setClassName(classEntity.getClassName()!=null ? classEntity.getClassName() : classModel.getClassName());
		classModel.setClassNumber(classEntity.getClassNumber()!=null ? classEntity.getClassNumber() : classModel.getClassNumber());
		classModel.setIsActive(classEntity.getIsActive()!=null ? classEntity.getIsActive() : classModel.getIsActive());
		
	}
	
	private void modelToEntity(ClassModel classModel, ClassEntity classEntity) {
		classEntity.setClasssId(classModel.getId()!=null ? classModel.getId() : classEntity.getClasssId()); 
		classEntity.setClassName(classModel.getClassName()!=null ? classModel.getClassName() : classEntity.getClassName());
		classEntity.setClassNumber(classModel.getClassNumber()!=null ? classModel.getClassNumber() : classEntity.getClassNumber());
		classEntity.setIsActive(classModel.getIsActive()!=null ? classModel.getIsActive() : classEntity.getIsActive());
		
	}

	public ResponseOperationResult<ClassModel> createOrUpdate(ClassModel classModel, String user) {
		ResponseOperationResult<ClassModel> response = new ResponseOperationResult<>();
		try {
			Integer id = classModel.getId() == null ? null : classModel.getId();

			if (id != null) {
				ClassEntity classData = classRepo.findById(id).get();
				modelToEntity(classModel, classData);
				classData.setUpdateDate(new Date());
				classData.setUpdatedBy(user);
				classRepo.save(classData);
			} else {
				ClassEntity classData = new ClassEntity();
				modelToEntity(classModel, classData);
				classData.setCraeateDate(new Date());
				classData.setCreatedBy(user);
				classData.setIsActive(1);
				classRepo.save(classData);
			}
			response.setResponse(classModel);
		} catch (Exception e) {

		}
		return response;
	
	}
	
}
