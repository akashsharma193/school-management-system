package com.school.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="homework")
public class Homework {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="class_id")
	private Integer classId;
	@Column(name="student_id")
	private Integer studentId;
	@Column(name="assign_homework")
	private String assignHomework;
}
