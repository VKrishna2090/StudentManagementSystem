# Student Management System
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
[![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white) 

## Technologies Used/Dependencies
- Java 17.0.1
- Swing / JavaFX
- Maven 3.8.6
- JFreeChart 1.5.3
- MySQL Connector JDBC Driver 8.0.29
- MySQL Database

## Features
1. Add new student details: roll number, name and marks in three subjects
2. View details of all students as a table
3. Update details of any students using their roll number
4. Delete a student's record using their roll number
5. Chart the marks of all students in each subject

## Installation and Running the Project
1. ```git clone [this repo URL]```
2. ```cd [cloned-dir]```
3. Create a MySQL database and create a table named students (rno, name, m1, m2, m3)
4. Update the connectionString in class src/main/java/com/example/db/DbHandler.java
5. ```mvn clean install```
6. ```mvn exec:java```

## Screenshots
