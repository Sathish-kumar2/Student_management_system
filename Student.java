 package com.student_management_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private String name;
    private String studentID;
    private List<String> courses;
    private int balance;
    private static int idCounter = 0;

    public Student(String name) {
        this.name = name;
        this.studentID = generateStudentID();
        this.courses = new ArrayList<>();
        this.balance = 0;
    }

    private String generateStudentID() {
        idCounter++;
        return String.format("%05d", idCounter);
    }

    public void enroll(String course) {
        courses.add(course);
    }

    public void payTuition(int amount) { 
        balance -= amount;
    }

    public void addFees(int amount) {
        balance += amount;
    }

    public String getStatus() {
        return "Name: " + name + "\n" +
               "ID: " + studentID + "\n" +
               "Courses Enrolled: " + String.join(", ", courses) + "\n" +
               "Balance: $" + balance;
    }

    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getBalance() {
        return balance;
    }
}
