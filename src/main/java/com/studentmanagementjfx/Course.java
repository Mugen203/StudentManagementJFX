package com.studentmanagementjfx;

public class Course {
    private int courseId;
    private String courseName;
    private  int creditHours;
    private Lecturer courseLecturer;


    public Course(int courseId, String courseName, int creditHours,  Lecturer courseLecturer) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.courseLecturer = courseLecturer;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Lecturer[] getCourseLecturer() {
        return new Lecturer[]{courseLecturer};
    }

    public void setCourseLecturer(Lecturer courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
}
