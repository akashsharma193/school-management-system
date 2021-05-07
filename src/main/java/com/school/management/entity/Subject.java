package com.school.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="subject")
@Setter
@Getter
public class Subject {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="subjec_name")
	private String subjectName;
	@Column(name="is_active")
	private Integer isActive;
}
