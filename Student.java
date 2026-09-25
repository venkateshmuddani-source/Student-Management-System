package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private String email;
    private String phone;
    private double marks;

    public Student() {
    }

    public Student(int id, String name, int age, String course,
            String email, String phone, double marks) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.phone = phone;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid Marks!");
        }
    }

    public char getGrade() {

        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void displayStudent() {

        System.out.println("------------------------------------------");
        System.out.printf("%-8s : %d%n", "ID", id);
        System.out.printf("%-8s : %s%n", "Name", name);
        System.out.printf("%-8s : %d%n", "Age", age);
        System.out.printf("%-8s : %s%n", "Course", course);
        System.out.printf("%-8s : %s%n", "Email", email);
        System.out.printf("%-8s : %s%n", "Phone", phone);
        System.out.printf("%-8s : %.2f%n", "Marks", marks);
        System.out.printf("%-8s : %c%n", "Grade", getGrade());
        System.out.println("------------------------------------------");
    }


}
