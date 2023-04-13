package com.studentmanagementjfx;

public class Lecturer {
	private String lecturerFirstName;
	private  String lecturerLastName;
	private String staffId;
	private String[] phoneNum;
	private String staffEmail;
	private Course course;
	private int assignedCreditHours;
	private Department department;
	
	//Constructor
	public Lecturer(String staffId, String lecturerFirstName, String lecturerLastName, String[] phoneNum, String staffEmail, Course course, int assignedCreditHours, Department department) {
		this.staffId = staffId;
		this.lecturerFirstName = lecturerFirstName;
		this.lecturerLastName = lecturerLastName;
		this.phoneNum = phoneNum;
		this.staffEmail = staffEmail;
		this.course = course;
		this.assignedCreditHours = assignedCreditHours;
		this.department = department;
		
	}
	
	public String getLecturerFirstName() {
		return lecturerFirstName;
	}
	public void setLecturerFirstName(String lecturerFirstName) {
		this.lecturerFirstName = lecturerFirstName;
	}

	public void setLecturerLastName(String lecturerLastName) {
		this.lecturerLastName = lecturerLastName;
	}

	public String getLecturerLastName() {
		return lecturerLastName;
	}

	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String[] getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String[] phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public Course[] getCourse() {
		return new Course[]{course};
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getAssignedCreditHours() {
		return assignedCreditHours;
	}
	public void setAssignedCreditHours(int assignedCreditHours) {
		this.assignedCreditHours = assignedCreditHours;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
