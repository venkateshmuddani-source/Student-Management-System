# 🎓 Student Management System (Java)

A console-based **Student Management System** developed in **Java** using Object-Oriented Programming (OOP) principles. This application allows users to manage student records efficiently with CRUD operations, data validation, sorting, searching, dashboard statistics, and file handling for persistent storage.

---

## 🚀 Features

### 👨‍🎓 Student Management
- ➕ Add Student
- 📋 View All Students
- 🔍 Search Student by ID
- 🔍 Search Student by Name (Case-Insensitive)
- ✏️ Update Student Details
- 🗑️ Delete Student with Confirmation

### ✅ Data Validation
- Prevent Duplicate Student IDs
- Email Validation
- Phone Number Validation
- Age Validation
- Marks Validation

### 📊 Dashboard
- Total Students
- Average Marks
- Highest Marks Student
- Lowest Marks Student
- Grade Distribution (A, B, C, D, F)

### 📂 File Handling
- Automatically saves student records
- Automatically loads data when the application starts
- Persistent storage using a text file

### 📑 Sorting
- Sort by Student ID
- Sort by Student Name
- Sort by Student Marks

---

## 🛠️ Technologies Used

- Java (JDK 24)
- Object-Oriented Programming (OOP)
- Java Collections (ArrayList)
- File Handling
- BufferedReader & BufferedWriter
- Comparator
- Scanner

---

## 📁 Project Structure

```
StudentManagementSystem/
│
├── data/
│   └── students.txt
│
├── src/
│   ├── main/
│   │   └── Main.java
│   │
│   ├── model/
│   │   └── Student.java
│   │
│   └── service/
│       └── StudentManager.java
│
├── out/
│
└── README.md
```

---

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/StudentManagementSystem.git
```

### 2. Open the Project

Open the project in **Visual Studio Code** or any Java IDE.

### 3. Compile

```bash
javac -d out src/model/*.java src/service/*.java src/main/*.java
```

### 4. Run

```bash
java -cp out main.Main
```

---

## 📸 Console Menu

```
=================================
 Student Management System
=================================
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Dashboard
7. Sort Students
8. Exit
=================================
```

---

## 💡 Concepts Implemented

- Classes & Objects
- Constructors
- Encapsulation
- Method Overloading
- ArrayList
- Iterators
- Loops
- Conditional Statements
- Comparator
- File Handling
- Exception Handling
- Input Validation
- CRUD Operations

---

## 🎯 Learning Outcomes

Through this project, I learned:

- Object-Oriented Programming in Java
- CRUD Operations
- Working with ArrayList
- Data Validation Techniques
- Sorting using Comparator
- Searching Algorithms
- File Handling
- Building a Modular Java Application

---

## 🚀 Future Improvements

- Java Swing GUI
- Spring Boot Backend
- MySQL Database
- REST API
- React Frontend
- Login Authentication
- Export Student Data (PDF/Excel)

---

