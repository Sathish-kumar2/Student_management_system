package com.student_management_system;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {
    private Map<String, Student> students;
    private Map<String, Course> courses;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new HashMap<>();
        courses = new HashMap<>();
        scanner = new Scanner(System.in);

        courses.put("Java Fullstack", new Course("jfs", 5000));
        courses.put("Cyber Security", new Course("cs", 3000));
        courses.put("Data Science", new Course("ds", 4000));
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = new Student(name);
        students.put(student.getStudentID(), student);
        System.out.println("Student added with ID: " + student.getStudentID());
    }

    public void enrollStudent() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);
        if (student != null) {
            System.out.print("Enter course to enroll in: ");
            String courseName = scanner.nextLine();
            Course course = courses.get(courseName);
            if (course != null) {
                student.enroll(courseName);
                student.addFees(course.getCourseFee());
                System.out.println("Enrolled in course: " + courseName);
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public void viewBalance() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);
        if (student != null) {
            System.out.println("Current balance: $" + student.getBalance());
        } else {
            System.out.println("Student not found.");
        }
    }

    public void payTuition() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);
        if (student != null) {
            System.out.print("Enter amount to pay: ");
            int amount = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            student.payTuition(amount);
            System.out.println("Payment successful.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void showStatus() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = students.get(studentID);
        if (student != null) {
            System.out.println(student.getStatus());
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. View Balance");
            System.out.println("4. Pay Tuition");
            System.out.println("5. Show Status");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.enrollStudent();
                    break;
                case 3:
                    sms.viewBalance();
                    break;
                case 4:
                    sms.payTuition();
                    break;
                case 5:
                    sms.showStatus();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
