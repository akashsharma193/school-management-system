package com.school.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="role")
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="role_name")
	private String roleName;
	@Column(name="is_active")
	private Integer isActive;
	public Role(Integer id, String roleName, Integer isActive) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.isActive = isActive;
	}
	public Role() {}
	
	
	
	
}
