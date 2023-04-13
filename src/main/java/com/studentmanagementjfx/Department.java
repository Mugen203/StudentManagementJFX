package com.studentmanagementjfx;

public class Department {
	private String departmentName;
	private int departmentId;
	private Lecturer headDepartment;
	private  Lecturer lecturers;
	public Department( int departmentId, String departmentName, Lecturer headDepartment, Lecturer lecturers) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.headDepartment = headDepartment;
		this.lecturers =lecturers;
	}
	
	//Assessors and Mutators
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public Lecturer getHeadDepartment() {
		return headDepartment;
	}
	public void setHeadDepartment(Lecturer headDepartment) {
		this.headDepartment = headDepartment;
	}

	public Lecturer[] getLecturers() {
		return new Lecturer[]{lecturers};
	}

	public void setLecturers(Lecturer lecturers) {
		this.lecturers = lecturers;
	}
}

