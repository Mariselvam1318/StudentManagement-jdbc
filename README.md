# Student Management System

## Overview

The Student Management System is a Java application that allows you to manage student records in a MySQL database. It includes functionalities to add, retrieve, update, display, and delete student records. This project demonstrates the use of JDBC for database operations and basic Java programming concepts.

## Features

- **Add Student:** Insert a new student record into the database.
- **Get Student by ID:** Retrieve and display a student's details based on their ID.
- **Display All Students:** List all student records in the database.
- **Update Student:** Modify an existing student's details.
- **Delete Student:** Remove a student record from the database.

## Prerequisites

- **Java Development Kit (JDK):** Ensure JDK 8 or higher is installed on your system.
- **MySQL Database:** Ensure MySQL is installed and running.

## Database Setup

1. **Create Database:**

   ```sql
   CREATE DATABASE db;
Select the Database:

sql
Copy code
USE db;
Create the Student Table:
sql
CREATE TABLE Student (
    Student_Id INT PRIMARY KEY,
    Student_Name VARCHAR(255),
    Student_Class VARCHAR(20),
    Student_Mark INT
);
Check Table Structure:
sql
DESC Student;
Compilation and Execution
Compile the Program:
bash
javac -d . DbConnection.java Main.java Student.java StudentDao.java
Run the Program:
bash
java studentmanagement.Main

Code Explanation
Imports
java.sql.*: Imports utility classes for database operations such as Connection, DriverManager, PreparedStatement, ResultSet, and SQLException.

DbConnection.java
DbConnection: Manages the connection to the MySQL database.
getConnection(): Returns a Connection object for connecting to the database using JDBC.

Student.java
Student: Represents a student with attributes for ID, name, class, and mark.
Constructor: Initializes the student object.
Getters and Setters: Access and modify the student's attributes.

StudentDao.java
StudentDao: Provides methods for database operations related to students.
addStudent(Student student): Inserts a new student record into the database.
getStudent(int studentId): Retrieves a student record by ID.
displayStudents(): Displays all student records.
deleteStudent(int id): Deletes a student record by ID.
updateStudent(Student student): Updates an existing student record.

Main.java
Main: Contains the user interface and interaction logic for the student management system.
User Interface: Displays a menu and handles user input for different operations.
Operations: Calls appropriate methods from StudentDao to perform CRUD (Create, Read, Update, Delete) operations.

Sample Output

*** Student Management System ***
1. Add Student
2. Get Student by ID
3. Display All Students
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 1
Enter Student Id: 1
Enter Student Name: John
Enter Student Class: 10
Enter Student Mark: 95
Student Added Successfully!!

Enter your choice: 2
Enter Student Id: 1
Student Details
ID :1
Name :John
Class :10
Mark :95

Enter your choice: 3
All Student Details
Student_Id  Student_Name         Student_Class   Student_Mark
1          John                10              95

Enter your choice: 4
Enter Student Id to Update: 1
Enter Student Name: Jane
Enter Student Class: 11
Enter Student Mark: 98
Student Updated Successfully!!

Enter your choice: 5
Enter Student Id to Delete :
1
Student deleted Successfully!!

Enter your choice: 6
Exiting...
