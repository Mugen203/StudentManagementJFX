package StudentManagementSystem;

public class Courses {
	private String courseID;
	private String courseName;
	private int creditHours;
	
	//Constructor
	public Courses(String courseID, String courseName, int creditHours) {
		this.courseID = courseID;
		this.setCourseName(courseName);
		this.setCreditHours(creditHours);
	}
	
	//Assessors and mutators
	public String getCourseID () {
		return courseID;
	}
	
	public void setCourseID (String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
}
