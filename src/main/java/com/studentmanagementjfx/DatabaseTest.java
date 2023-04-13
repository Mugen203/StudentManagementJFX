package com.studentmanagementjfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private final Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studentdb", "root", "L!n*xT00ls");

    DatabaseTest() throws SQLException {
    }

    @org.junit.jupiter.api.Test
    void getInstance() {
        assertNotNull(Database.getInstance());
    }

    @org.junit.jupiter.api.Test
    void setDbConnection() throws SQLException {
        Connection dbConnection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studentdb", "root", "L!n*xT00ls");
        System.out.println("Connection established successfully.");
    }

    @org.junit.jupiter.api.Test
    void createStudentDB() throws SQLException {
        Statement createStudentDBStatement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "student_id VARCHAR(10) PRIMARY KEY, " +
                "first_name VARCHAR(50), " +
                "last_name VARCHAR(50), " +
                "age INTEGER, " +
                "hall VARCHAR(50)" +
                ")";
        createStudentDBStatement.executeUpdate(sql);
        assertTrue(connection.getMetaData().getTables(null, null, "students", null).next(), "Table students should exist");
    }

    @org.junit.jupiter.api.Test
    void createLecturerDB() throws SQLException {
        Statement createLecturerDBStatement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS lecturers (" +
                "staff_id VARCHAR(10) PRIMARY KEY, " +
                "lecturer_first_name VARCHAR(50), " +
                "lecturer_last_name VARCHAR(50), " +
                "phoneNum VARCHAR(255), " +
                "staff_email VARCHAR(50), " +
                "assigned_credit_hours INTEGER, "+
                "courses_taught VARCHAR(255) "+
                "department_Id INTEGER"+
                ")";
        createLecturerDBStatement.executeUpdate(sql);
        assertTrue(connection.getMetaData().getTables(null, null, "lecturer", null).next(), "Table students should exist");
    }

    @org.junit.jupiter.api.Test
    void createDepartment() {
    }

    @org.junit.jupiter.api.Test
    void createDegree() {
    }

    @org.junit.jupiter.api.Test
    void createDiploma() {
    }

    @org.junit.jupiter.api.Test
    void createCourse() {
    }

    @org.junit.jupiter.api.Test
    void insertStudent() {
    }

    @org.junit.jupiter.api.Test
    void insertLecturer() {
    }

    @org.junit.jupiter.api.Test
    void insertDepartment() {
    }

    @org.junit.jupiter.api.Test
    void insertDegree() {
    }

    @org.junit.jupiter.api.Test
    void insertDiploma() {
    }

    @org.junit.jupiter.api.Test
    void insertCourse() {
    }

    @org.junit.jupiter.api.Test
    void endDBConnection() {
    }
}