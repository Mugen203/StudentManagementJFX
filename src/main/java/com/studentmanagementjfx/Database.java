package com.studentmanagementjfx;

import java.sql.*;
import java.util.Arrays;

public class Database{

    //Put the JDBC driver database path above
    private static Database instance;
    private static final String JDBC_Driver = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb: //localhost:3306/studentdb";

    //Create a null connection here
    private Connection dbConnection = null;

    //Constructor
    private Database (){
        try{
            //Load the driver
            Class.forName(JDBC_Driver);

            System.out.println("Establishing connection...");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    //Create a method to get an instance of the StudentManagementSystem.Database class: Singleton Design Pattern
    public static Database getInstance(){
        if (instance == null ){
            instance = new Database();
        }
        return  instance;
    }
    public Connection setDbConnection () throws SQLException{
        return dbConnection = DriverManager.getConnection(DB_URL);
    }

    //Create tables in the database if one does not already exist
    public void createStudentDB() throws SQLException{
        try {
            Statement createStudentDBStatement = setDbConnection().createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id VARCHAR(10) PRIMARY KEY, " +
                    "first_name VARCHAR(50), " +
                    "last_name VARCHAR(50), " +
                    "age INTEGER, " +
                    "hall VARCHAR(50)" +
                    ")";
            createStudentDBStatement.executeUpdate(sql);
            System.out.println("The StudentManagementSystem.Student table has been created");
        }catch (SQLException e){
            System.err.println("The StudentManagementSystem.Student table could not be created. Error: " + e.getMessage());
            throw e;
        }
    }

    public void createLecturerDB() throws SQLException{
        try {
            Statement createLecturerDBStatement = dbConnection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS lecturers(" +
                    "staff_id VARCHAR(10) PRIMARY KEY, " +
                    "lecturer_first_name VARCHAR(50), " +
                    "lecturer_last_name VARCHAR(50), " +
                    "phoneNum VARCHAR(255)," +
                    "staff_email VARCHAR(50)," +
                    "assigned_credit_hours INTEGER,"+
                    "courses_taught VARCHAR(255)"+
                    "department_Id INTEGER"+
                    ")";
            createLecturerDBStatement.executeUpdate(sql);
            System.out.println("The StudentManagementSystem.Lecturer table has been created");
        }catch (SQLException e){
            System.err.println("The StudentManagementSystem.Lecturer table could not be created. Error: " + e.getMessage());
            throw e;
        }
    }

    public void createDepartment() throws  SQLException{
        try{
            Statement createDepartmentDB = dbConnection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS departments(" +
                    "department_id VARCHAR(10) PRIMARY KEY, " +
                    "department_name VARCHAR(50), " +
                    "headDepartment VARCHAR(50), " +
                    "department_lecturer_first_name VARCHAR(255)," +
                    "department_lecturer_last_name VARCHAR(255)," +
                    ")";
            System.out.println("The StudentManagementSystem.Department table was created successfully.");
        }catch (SQLException e){
            System.err.println("The StudentManagementSystem.Department table could not be created. Error: " + e.getMessage());
        }
    }

    public void createDegree() throws SQLException {
        try {
            Statement createDegreeDB = dbConnection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS degrees(" +
                    "degree_id VARCHAR(10) PRIMARY KEY, " +
                    "degree_name VARCHAR(50), " +
                    "required_courses VARCHAR(255)" +
                    ")";
            createDegreeDB.execute(sql);
            System.out.println("The StudentManagementSystem.Degree table was created successfully.");
        } catch (SQLException e) {
            System.err.println("The StudentManagementSystem.Degree table could not be created. Error: " + e.getMessage());
        }
    }

    public void createDiploma() throws SQLException {
        try {
            Statement createDiplomaDB = dbConnection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS diploma(" +
                    "diploma_id VARCHAR(10) PRIMARY KEY, " +
                    "diploma_name VARCHAR(50), " +
                    "required_courses VARCHAR(255)" +
                    ")";
            createDiplomaDB.execute(sql);
            System.out.println("The StudentManagementSystem.Degree table was created successfully.");
        } catch (SQLException e) {
            System.err.println("The StudentManagementSystem.Degree table could not be created. Error: " + e.getMessage());
        }
    }

    public void createCourse() throws SQLException {
        try {
            Statement createCourseDB = dbConnection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS courses(" +
                    "course_id INT PRIMARY KEY, " +
                    "course_name VARCHAR(50), " +
                    "credit_hours INT, " +
                    "department_id INT, " +
                    "department_name VARCHAR(50), " +
                    "lecturer_first_name VARCHAR(50), " +
                    "lecturer_last_name VARCHAR(50)" +
                    ")";
            createCourseDB.executeUpdate(sql);
            System.out.println("The StudentManagementSystem.Course table was created successfully.");
        } catch (SQLException e) {
            System.err.println("The StudentManagementSystem.Course table could not be created. Error: " + e.getMessage());
        }
    }


    public void insertStudent(Student student) throws SQLException {
        //Create a null prepared statement here
        PreparedStatement preparedStatement;

        //String to hold the sql syntax
        String sql = "";
        preparedStatement = dbConnection.prepareStatement(sql);

        //Populate the database
        preparedStatement.setString(1,student.getStudentId());
        preparedStatement.setString(2,student.getFirstName());
        preparedStatement.setString(3,student.getLastName());
        preparedStatement.setString(4,student.getHall());

        //Updates the database
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }
    public void insertLecturer(Lecturer lecturer) throws SQLException {
        //Create a null prepared statement here
        PreparedStatement preparedStatement;

        //String to hold the sql syntax
        String sql = "";
        preparedStatement = dbConnection.prepareStatement(sql);

        //Populate the database
        preparedStatement.setString(1,lecturer.getStaffId());
        preparedStatement.setString(2, lecturer.getLecturerFirstName());
        preparedStatement.setString(3,lecturer.getLecturerLastName());

        //Cast the string array to a string
        String phoneNum = Arrays.toString(lecturer.getPhoneNum());

        preparedStatement.setString(4,phoneNum);
        preparedStatement.setString(5,lecturer.getStaffEmail());

        Course[] courses = lecturer.getCourse();
        for (Course course : courses) {
            preparedStatement.setInt(6, course.getCourseId());
            preparedStatement.setString(7, course.getCourseName());
            preparedStatement.setInt(8, lecturer.getAssignedCreditHours());
            preparedStatement.setString(9, lecturer.getDepartment().getDepartmentName());
            preparedStatement.setObject(10, lecturer.getDepartment());
        }
        //Updates the database
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }

    public void insertDepartment(Department department) throws SQLException {
        //Create a null prepared statement here
        PreparedStatement preparedStatement;

        //String to hold the sql syntax
        String sql = "";
        preparedStatement = dbConnection.prepareStatement(sql);

        //Populate the database
        preparedStatement.setInt(1, department.getDepartmentId());
        preparedStatement.setString(2, department.getDepartmentName());
        preparedStatement.setString(3, department.getHeadDepartment().getLecturerFirstName());
        preparedStatement.setString(4, department.getHeadDepartment().getLecturerLastName());

        //Updates the database
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

    }
    public void insertDegree(Degree degree) throws SQLException {
        //Create a null prepared statement here
        PreparedStatement preparedStatement;

        //String to hold the sql syntax
        String sql = "";
        preparedStatement = dbConnection.prepareStatement(sql);


        //Populate the database
        preparedStatement.setString(1, degree.getDegreeId());
        preparedStatement.setString(2, degree.getDegreeName());

        //Casting straightaway in the preparedStatement expression
        preparedStatement.setString(3, Arrays.toString(degree.getRequiredCourses()));

        //Updates the database
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }
    public void insertDiploma(Diploma diploma) throws SQLException {
        //Create a null prepared statement here
        PreparedStatement preparedStatement;

        //String to hold the sql syntax
        String sql = "";
        preparedStatement = dbConnection.prepareStatement(sql);

        //Populate the database
        preparedStatement.setString(1, diploma.getDegreeId());
        preparedStatement.setString(2, diploma.getDiplomaName());
        preparedStatement.setString(3, Arrays.toString(diploma.getRequiredCourses()));

        //Updates the database
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }

    public void insertCourse(Course course) throws SQLException{
        //Create a null prepared statement here
        PreparedStatement preparedStatement;

        //String to hold the sql syntax
        String sql = "";
        preparedStatement = dbConnection.prepareStatement(sql);

        //Populate the database
        preparedStatement.setInt(1, course.getCourseId());
        preparedStatement.setString(2, course.getCourseName());
        preparedStatement.setInt(3, course.getCreditHours());

        //Loop through to get the required lecturer object info
        Lecturer[] lecturers = course.getCourseLecturer();
        for (Lecturer lecturer : lecturers) {
            preparedStatement.setInt(4, lecturer.getDepartment().getDepartmentId());
            preparedStatement.setString(5, lecturer.getDepartment().getDepartmentName());
            preparedStatement.setObject(6, lecturer.getLecturerFirstName());
            preparedStatement.setObject(7, lecturer.getLecturerLastName());
        }

        //Updates the database
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }

    public void endDBConnection ()throws SQLException {
        dbConnection.close();
    }
}
