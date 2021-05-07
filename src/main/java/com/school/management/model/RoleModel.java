package com.school.management.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RoleModel {
	private Integer id;
	private String roleName;
	private Integer isActive;
	public RoleModel(Integer id, String roleName, Integer isActive) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.isActive = isActive;
	}
}
