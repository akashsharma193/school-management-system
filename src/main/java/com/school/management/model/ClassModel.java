package com.school.management.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClassModel {

	private Integer id;
	private String className;
	private String classNumber;
	private Integer isActive;
	private Date updateDate;
	private Date craeateDate;
	private String createdBy;
	private String updatedBy;
}
