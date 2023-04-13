package com.studentmanagementjfx;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String studentId;
    private String hall;
    private Course course;

    // Constructors
    public Student(String firstName, String lastName,String studentId, int age, String hall, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.age = age;
        this.hall = hall;
        this.course = course;
    }

    public Student(String firstName, String lastName,String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    //Assessors and Mutators
  public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHall() {
        return hall;
    }


    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public Course[] getCourse() {
        return new Course[]{course};
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
