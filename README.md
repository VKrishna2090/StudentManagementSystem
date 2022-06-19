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
### Splash Screen
![splash screen](screenshots/1%20splash%20screen.jpg)
### Home Page
![home screen](screenshots/2%20home%20page.jpg)
### View All Students Page
![all students screen](screenshots/3%20view%20all%20students%20before%20adding.jpg)
### Adding New Student Record
![add new student screen](screenshots/4%20add%20new%20student%20details.jpg)
![added new record screen](screenshots/5%20Added%20new%20record.jpg)
![all students after adding student screen](screenshots/6%20After%20adding%20new%20student.jpg)
### Updating a Student's Record
![roll number for updating screen](screenshots/7%20Taking%20roll%20no%20to%20be%20updating.jpg)
![updating record screen](screenshots/8%20Updating%20existing%20record.jpg)
![updated record screen](screenshots/9%20Record%20updated.jpg)
![all students after updating screen](screenshots/10%20after%20updating%20the%20record.jpg)
### Deleting a Student's Record
![roll number for deleting screen](screenshots/11%20Taking%20roll%20no%20to%20be%20deleted.jpg)
![deleted record screen](screenshots/12%20Record%20deleted.jpg)
![all students after deleting screen](screenshots/13%20After%20deleting%20the%20record.jpg)
### Deleting a Student's Record
![charts options page](screenshots/14%20Charts%20page.jpg)
![chart first 5 of all subjects](screenshots/15%20Chart%20of%20first%205%20students.jpg)
![chart top 5 of subject 1](screenshots/16%20Chart%20of%20top%205%20in%20subject%201.jpg)