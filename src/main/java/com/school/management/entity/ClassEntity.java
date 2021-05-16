package com.school.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="class")
@Setter
@Getter
public class ClassEntity {

	@Id
	@GeneratedValue
	@Column(name="class_id")
	private Integer classsId;
	@Column(name="class_name")
	private String className;
	@Column(name="class_number")
	private String classNumber;
	@Column(name="is_active")
	private Integer isActive;
	@Column(name="update_date")
	private Date updateDate;
	@Column(name="craete_date")
	private Date craeateDate;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="updated_by")
	private String updatedBy;
	
	@ManyToMany(mappedBy = "classEntity")
	@JsonIgnore
    private List<UserInfo> userInfo = new ArrayList<>();  
	
	
}
