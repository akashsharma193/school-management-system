package com.school.management.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user",uniqueConstraints={@UniqueConstraint(columnNames={"email","mobile","adhar_number"})})
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="middle_name")
	private String middleName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="address")
	private String address;
	@Column(name="role_id")
	private Integer roleId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Role role; 
	
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private Integer mobile;
	@Column(name="adhar_number")
	private Integer adharNumber;
	@Column(name="is_available_on_web")
	private Integer isAvailableOnWeb;
	@Column(name="profile_picture_name")
	private String profilePictureName;
	@Column(name="profile_picture_data")
	private String profilePictureData;
	@Column(name="profile_picture_path")
	private String profilePicturePath;
	@Column(name="profile_picture_size")
	private Integer profilePictureSize;
	@Column(name="update_date")
	private Date updateDate;
	@Column(name="craete_date")
	private Date craeateDate;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="is_active")
	private Integer isActive;
	
}
