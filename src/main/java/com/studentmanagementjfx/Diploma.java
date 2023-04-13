package com.studentmanagementjfx;

public class Diploma extends Degree{
	private String diplomaName;
	
	public Diploma(String degreeId, String diplomaName, Course[] requiredCourses) {
		super( degreeId, diplomaName, requiredCourses);
		
	}
	public String getDiplomaName() {
		return diplomaName;
	}
	public void setDiplomaName(String diplomaName) {
		this.diplomaName = diplomaName;
	}

}
