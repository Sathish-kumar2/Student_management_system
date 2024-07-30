package com.student_management_system;

public class Course {
    private String courseName;
    private int courseFee;

    public Course(String courseName, int courseFee) {
        this.courseName = courseName;
        this.courseFee = courseFee;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseFee() {
        return courseFee;
    }
}

