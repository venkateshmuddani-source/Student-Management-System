package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Collections;
import java.util.Comparator;

import model.Student;

public class StudentManager {

    private static final String FILE_NAME = "data/students.txt";

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        
        saveToFile();

        System.out.println("Student added successfully!");
    }

    public void addStudent(int id, String name, int age,
            String course, String email,
            String phone, double marks) {

        if (isDuplicateId(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        if (!isValidEmail(email)) {
            System.out.println("Invalid Email!");
            return;
        }

        if (!isValidPhone(phone)) {
            System.out.println("Invalid Phone Number!");
            return;
        }
        

        if (!isValidAge(age)) {
            System.out.println("Age must be between 15 and 35.");
            return;
        }

        Student student = new Student(
                id,
                name,
                age,
                course,
                email,
                phone,
                marks);

        students.add(student);
        saveToFile();

        System.out.println("Student added successfully!");
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {

            student.displayStudent();

        }

    }

    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("\nStudent Found");
                student.displayStudent();

                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void updateStudent(int id, Scanner sc) {

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println("\nStudent Found!");

                System.out.println("\n===== Update Menu =====");
                System.out.println("1. Update Name");
                System.out.println("2. Update Age");
                System.out.println("3. Update Course");
                System.out.println("4. Update Email");
                System.out.println("5. Update Phone");
                System.out.println("6. Update Marks");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                boolean updated = false;

                switch (choice) {

                    case 1:
                        System.out.print("Enter New Name: ");
                        student.setName(sc.nextLine());
                        updated = true;
                        System.out.println("Name updated successfully!");
                        break;

                    case 2:
                        System.out.print("Enter New Age: ");
                        int newAge = sc.nextInt();

                        if (!isValidAge(newAge)) {
                            System.out.println("Age must be between 15 and 35.");
                            return;
                        }

                        student.setAge(newAge);
                        updated = true;
                        System.out.println("Age updated successfully!");
                        break;

                    case 3:
                        System.out.print("Enter New Course: ");
                        student.setCourse(sc.nextLine());
                        updated = true;
                        System.out.println("Course updated successfully!");
                        break;

                    case 4:
                        System.out.print("Enter New Email: ");
                        String newEmail = sc.nextLine();

                        if (!isValidEmail(newEmail)) {
                            System.out.println("Invalid Email!");
                            return;
                        }

                        student.setEmail(newEmail);
                        updated = true;
                        System.out.println("Email updated successfully!");
                        break;

                    case 5:
                        System.out.print("Enter New Phone: ");
                        String newPhone = sc.nextLine();

                        if (!isValidPhone(newPhone)) {
                            System.out.println("Invalid Phone Number!");
                            return;
                        }

                        student.setPhone(newPhone);
                        updated = true;
                        System.out.println("Phone updated successfully!");
                        break;

                    case 6:
                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        if (newMarks < 0 || newMarks > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                            return;
                        }

                        student.setMarks(newMarks);
                        updated = true;
                        System.out.println("Marks updated successfully!");
                        break;

                    case 7:
                        System.out.println("Update cancelled.");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }
                
                if (updated) {
                    saveToFile();
                    System.out.println("Student updated successfully!");
                }

                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int id, Scanner sc) {

        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {

            Student student = iterator.next();

            if (student.getId() == id) {

                System.out.println("\nStudent Found!");
                student.displayStudent();

                System.out.print("\nAre you sure you want to delete? (Y/N): ");

                char confirm = sc.next().toUpperCase().charAt(0);

                if (confirm == 'Y') {

                    iterator.remove();
                    saveToFile();

                    System.out.println("Student deleted successfully!");

                } else {

                    System.out.println("Delete cancelled.");

                }

                return;
            }

        }

        System.out.println("Student not found.");
    }

    private boolean isDuplicateId(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return true;
            }

        }

        return false;
    }

    private boolean isValidEmail(String email) {

        if (!email.contains("@")) {
            return false;
        }

        if (!email.contains(".")) {
            return false;
        }

        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (atIndex == 0) {
            return false;
        }

        if (dotIndex < atIndex + 2) {
            return false;
        }

        return true;
    }

    private boolean isValidPhone(String phone) {

        if (phone.length() != 10) {
            return false;
        }

        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }

        }

        return true;
    }

    private boolean isValidAge(int age) {

        return age >= 15 && age <= 35;

    }

    private void saveToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {

                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getCourse() + "," +
                                student.getEmail() + "," +
                                student.getPhone() + "," +
                                student.getMarks()

                );

                writer.newLine();

            }

            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }

    }
    
    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // We will process one student here
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                String email = data[4];
                String phone = data[5];
                double marks = Double.parseDouble(data[6]);

                Student student = new Student(
                        id,
                        name,
                        age,
                        course,
                        email,
                        phone,
                        marks);

                students.add(student);
            }

            if (!students.isEmpty()) {
                System.out.println(students.size() + " students loaded successfully.");
            }

        } catch (IOException e) {
            System.out.println("No previous data found.");
        }

    }


    public void searchStudentByName(String name) {

        boolean found = false;

        for (Student student : students) {

            if (student.getName().toLowerCase().contains(name.toLowerCase())) {

                System.out.println("\nStudent Found");
                student.displayStudent();
                found = true;
            }

        }
        if (!found) {
            System.out.println("Student not found.");
        }

    }

    public void sortById() {

        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                return Integer.compare(s1.getId(), s2.getId());

            }

        });

        System.out.println("Students sorted by ID successfully.");
        viewStudents();

    }

    public void sortByName() {

        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                return s1.getName().compareToIgnoreCase(s2.getName());

            }

        });

        System.out.println("Students sorted by Name successfully.");

        viewStudents();
    }

    public void sortByMarks() {

        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                return Double.compare(s2.getMarks(), s1.getMarks());

            }

        });

        System.out.println("Students sorted by Marks successfully.");

        viewStudents();
    }

    public void showDashboard() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        int totalStudents = students.size();

        double totalMarks = 0;
        double highestMarks = students.get(0).getMarks();
        double lowestMarks = students.get(0).getMarks();

        Student topper = students.get(0);
        Student lowestStudent = students.get(0);

        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeF = 0;

        for (Student student : students) {

            totalMarks += student.getMarks();

            if (student.getMarks() > highestMarks) {
                highestMarks = student.getMarks();
                topper = student;
            }

            if (student.getMarks() < lowestMarks) {
                lowestMarks = student.getMarks();
                lowestStudent = student;
            }

            switch (student.getGrade()) {

                case 'A':
                    gradeA++;
                    break;

                case 'B':
                    gradeB++;
                    break;

                case 'C':
                    gradeC++;
                    break;

                case 'D':
                    gradeD++;
                    break;

                default:
                    gradeF++;
            }

        }

        double averageMarks = totalMarks / totalStudents;

        System.out.println("\n========== DASHBOARD ==========");
        System.out.println("Total Students : " + totalStudents);
        System.out.printf("Average Marks  : %.2f%n", averageMarks);
        System.out.printf("Highest Marks  : %.2f%n", highestMarks);
        System.out.println("Topper         : " + topper.getName() + " (ID: " + topper.getId() + ")");
        System.out.printf("Lowest Marks   : %.2f%n", lowestMarks);
        System.out.println("Lowest Student : " + lowestStudent.getName() + " (ID: " + lowestStudent.getId() + ")");
        System.out.println();
        System.out.println("A Grade : " + gradeA);
        System.out.println("B Grade : " + gradeB);
        System.out.println("C Grade : " + gradeC);
        System.out.println("D Grade : " + gradeD);
        System.out.println("F Grade : " + gradeF);
        System.out.println("===============================");
    }

}