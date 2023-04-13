package com.studentmanagementjfx;

public class Degree {
	private String degreeName;
	private String degreeId;
	private Course[] requiredCourses;
	
	public Degree(String degreeId, String degreeName, Course[] requiredCourses) {
		this.degreeName = degreeName;
		this.degreeId = degreeId;
		this.requiredCourses = requiredCourses;
	}
	
	
	
	//Assessors and Mutators
	public String getDegreeName() {
		return degreeName;
	}
	
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	
	public String getDegreeId() {
		return degreeId;
	}
	
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	
	public Course[] getRequiredCourses() {
		return requiredCourses;
	}
	
	public void setRequiredCourses(Course[] requiredCourses) {
		this.requiredCourses = requiredCourses;
	}
	
}
