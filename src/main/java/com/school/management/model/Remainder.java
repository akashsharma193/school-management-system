package com.school.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notification")
public class Remainder {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="remainder")
	private String remainder;
	@Column(name="remainder_type")
	private String remainderType;
	@Column(name="remainder_msg")
	private String remainderMsg;
	@Column(name="is_active")
	private Integer isActive;
	
}
