package com.school.management.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserModel {

	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private Integer roleId;
	
	private RoleModel roleModel;
	private String password;
	private String email;
	
	private Integer mobile;
	private Integer adharNumber;
	private Integer isAvailableOnWeb;
	private String profilePictureName;
	private String profilePictureData;
	private String profilePicturePath;
	private Integer profilePictureSize;
	private Date updateDate;
	private Date craeateDate;
	private String createdBy;
	private String updatedBy;
	private Integer isActive;
}
