package com.school.management.entity;

import java.util.Date;

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
	@Column(name="student_id")
	private Integer studentId;
	@Column(name="teacher_id")
	private Integer teacherId;
	@Column(name="class_id")
	private Integer classId;
	@Column(name="subject_id")
	private Integer subjectId;

	@Column(name="homework_type")
	private Integer homeworkType;
	@Column(name="homework_text")
	private String homeworkText;
	@Column(name="homework_file_name")
	private String homeworkFileName;
	@Column(name="homework_file_path")
	private String homeworkFilePath;
	@Column(name="homework_file_data")
	private String homeworkFileData;
	@Column(name="homework_file_size")
	private Integer homeworkFileSize;
	@Column(name="homework_start_datae")
	private Date homeworkStartDatae;
	@Column(name="homework_end_date")
	private Date homeworkEndDate;

	@Column(name="homework_ans_type")
	private Integer homeworkAnsType;
	@Column(name="homework_ans_text")
	private String homeworkAnsText;
	@Column(name="homework_ans_file_name")
	private String homeworkAnsFileName;
	@Column(name="homework_ans_file_path")
	private String homeworkAnsFilePath;
	@Column(name="homework_ans_file_data")
	private String homeworkAnsFileData;
	@Column(name="homework_ans_file_size")
	private Integer homeworkAnsFileSize;
	@Column(name="homework_ans_end_date")
	private Date homeworkAnsEndDate;
	@Column(name="is_homework_completed")
	private Integer isHomeworkCompleted;
	@Column(name="is_active")
	private Integer isActive;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getHomeworkType() {
		return homeworkType;
	}
	public void setHomeworkType(Integer homeworkType) {
		this.homeworkType = homeworkType;
	}
	public String getHomeworkText() {
		return homeworkText;
	}
	public void setHomeworkText(String homeworkText) {
		this.homeworkText = homeworkText;
	}
	public String getHomeworkFileName() {
		return homeworkFileName;
	}
	public void setHomeworkFileName(String homeworkFileName) {
		this.homeworkFileName = homeworkFileName;
	}
	public String getHomeworkFilePath() {
		return homeworkFilePath;
	}
	public void setHomeworkFilePath(String homeworkFilePath) {
		this.homeworkFilePath = homeworkFilePath;
	}
	public String getHomeworkFileData() {
		return homeworkFileData;
	}
	public void setHomeworkFileData(String homeworkFileData) {
		this.homeworkFileData = homeworkFileData;
	}
	public Integer getHomeworkFileSize() {
		return homeworkFileSize;
	}
	public void setHomeworkFileSize(Integer homeworkFileSize) {
		this.homeworkFileSize = homeworkFileSize;
	}
	public Date getHomeworkStartDatae() {
		return homeworkStartDatae;
	}
	public void setHomeworkStartDatae(Date homeworkStartDatae) {
		this.homeworkStartDatae = homeworkStartDatae;
	}
	public Date getHomeworkEndDate() {
		return homeworkEndDate;
	}
	public void setHomeworkEndDate(Date homeworkEndDate) {
		this.homeworkEndDate = homeworkEndDate;
	}
	public Integer getHomeworkAnsType() {
		return homeworkAnsType;
	}
	public void setHomeworkAnsType(Integer homeworkAnsType) {
		this.homeworkAnsType = homeworkAnsType;
	}
	public String getHomeworkAnsText() {
		return homeworkAnsText;
	}
	public void setHomeworkAnsText(String homeworkAnsText) {
		this.homeworkAnsText = homeworkAnsText;
	}
	public String getHomeworkAnsFileName() {
		return homeworkAnsFileName;
	}
	public void setHomeworkAnsFileName(String homeworkAnsFileName) {
		this.homeworkAnsFileName = homeworkAnsFileName;
	}
	public String getHomeworkAnsFilePath() {
		return homeworkAnsFilePath;
	}
	public void setHomeworkAnsFilePath(String homeworkAnsFilePath) {
		this.homeworkAnsFilePath = homeworkAnsFilePath;
	}
	public String getHomeworkAnsFileData() {
		return homeworkAnsFileData;
	}
	public void setHomeworkAnsFileData(String homeworkAnsFileData) {
		this.homeworkAnsFileData = homeworkAnsFileData;
	}
	public Integer getHomeworkAnsFileSize() {
		return homeworkAnsFileSize;
	}
	public void setHomeworkAnsFileSize(Integer homeworkAnsFileSize) {
		this.homeworkAnsFileSize = homeworkAnsFileSize;
	}
	public Date getHomeworkAnsEndDate() {
		return homeworkAnsEndDate;
	}
	public void setHomeworkAnsEndDate(Date homeworkAnsEndDate) {
		this.homeworkAnsEndDate = homeworkAnsEndDate;
	}
	public Integer getIsHomeworkCompleted() {
		return isHomeworkCompleted;
	}
	public void setIsHomeworkCompleted(Integer isHomeworkCompleted) {
		this.isHomeworkCompleted = isHomeworkCompleted;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
}
