package com.school.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.school.management.Repo.SubjectRepo;
import com.school.management.common.CreatePagination;
import com.school.management.entity.Subject;
import com.school.management.entity.UserInfo;
import com.school.management.model.FilterParameter;
import com.school.management.model.ResponseOperationResult;
import com.school.management.model.SubjectModel;
import com.school.management.model.UserModel;
import com.school.management.util.FilterUtil;
import com.school.management.util.SearchCriteria;
import com.school.management.util.SearchOperation;

@Service
public class SubjectService {

	@Autowired
	SubjectRepo subjectRepo;

	public ResponseOperationResult<List<SubjectModel>> getSubjectList(FilterParameter filterParameter) {

		ResponseOperationResult<List<SubjectModel>> response = new ResponseOperationResult<>();
		response.setResponse(new ArrayList<SubjectModel>());

		List<SubjectModel> subjectModelList = new ArrayList();
		String id = filterParameter.getId();
		String subjecName = filterParameter.getSubjectName();
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
		if (!StringUtils.isEmpty(subjecName)) {
			sc = new SearchCriteria("subjecName", subjecName, SearchOperation.EQUAL);
			list.add(sc);
		}
		if (!StringUtils.isEmpty(isActive)) {
			sc = new SearchCriteria("isActive", isActive, SearchOperation.EQUAL);
			list.add(sc);
		}
		FilterUtil<Subject> filterUtil = new FilterUtil<Subject>();

		List<Subject> subjectData = new ArrayList<Subject>();
		Long recordTotal = (long) 0;
		if (from != null && to != null) {
			Pageable page = PageRequest.of(from, to);
			subjectData = subjectRepo.findAll(filterUtil.getSpecification(list), page).getContent();
		} else {
			subjectData = subjectRepo.findAll(filterUtil.getSpecification(list));
		}
		if (subjectData != null && !subjectData.isEmpty()) {
			recordTotal = (long) subjectData.size();
			for (Subject subject : subjectData) {
				SubjectModel subjectModel = new SubjectModel();
				entityToModel(subjectModel, subject);
				subjectModelList.add(subjectModel);
			}
		}
		response.setPageAttribute(CreatePagination.pagination(filterParameter, recordTotal, recordToShowOnPage));
		response.setResponse(subjectModelList);

		return response;
	
		
	}

	private void entityToModel(SubjectModel subjectModel, Subject subject) {
		subjectModel.setId(subject.getId()!=null ? subject.getId() : subjectModel.getId()); 
		subjectModel.setSubjectName(subject.getSubjectName()!=null ? subject.getSubjectName() : subjectModel.getSubjectName());
		subjectModel.setIsActive(subject.getIsActive()!=null ? subject.getIsActive() : subjectModel.getIsActive());
		
	}
	
	private void modelToEntity(SubjectModel subjectModel, Subject subject) {
		subject.setId(subjectModel.getId()!=null ? subjectModel.getId() : subject.getId()); 
		subject.setSubjectName(subjectModel.getSubjectName()!=null ? subjectModel.getSubjectName() : subject.getSubjectName());
		subject.setIsActive(subjectModel.getIsActive()!=null ? subjectModel.getIsActive() : subject.getIsActive());
		
	}

	public ResponseOperationResult<SubjectModel> createOrUpdate(SubjectModel subjectModel, String user) {
		ResponseOperationResult<SubjectModel> response = new ResponseOperationResult<>();
		try {
			Integer id = subjectModel.getId() == null ? null : subjectModel.getId();

			if (id != null) {
				Subject subjectData = subjectRepo.findById(id).get();
				modelToEntity(subjectModel, subjectData);
				subjectData.setUpdateDate(new Date());
				subjectData.setUpdatedBy(user);
				subjectRepo.save(subjectData);
			} else {
				Subject subjectData = new Subject();
				modelToEntity(subjectModel, subjectData);
				subjectData.setCraeateDate(new Date());
				subjectData.setCreatedBy(user);
				subjectData.setIsActive(1);
				subjectRepo.save(subjectData);
			}
			response.setResponse(subjectModel);
		} catch (Exception e) {

		}
		return response;
	
	}
	
}
