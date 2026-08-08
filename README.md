# Student Performance Analytics System

A web-based Student Performance Analytics System developed using Java Servlets, JSP, JDBC, and MySQL.

## Project Overview

This system manages student information and academic performance through a web-based application.

It provides student registration and login, marks management, student search, ranking, and performance analytics.

## Features

- Student registration with academic marks
- Student login and authentication
- Student logout
- Student search
- Student ranking based on total marks
- Performance analytics
- Class average calculation
- Pass/fail percentage analysis
- Topper and weakest student identification
- HashMap-based student data handling
- Database integration using JDBC and MySQL

## Technologies Used

- Java
- JSP (JavaServer Pages)
- Java Servlets
- JDBC
- MySQL
- Apache Tomcat 9
- HTML
- CSS
- Eclipse IDE

## Data Structures and Algorithms

The project uses Java data structures and search techniques for handling student records.

### Data Structures

- `ArrayList` – used for maintaining collections of student records
- `HashMap` – used for student lookup and mapping records by roll number

### Search

- Linear search
- HashMap-based lookup
- Search functionality through Servlets

## Project Structure

```text
StudentPerformanceAnalyticsSystem/
│
├── database/
│   └── student_db.sql
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/student/
│       │       ├── dao/
│       │       ├── ds/
│       │       ├── model/
│       │       └── web/
│       │
│       └── webapp/
│           ├── WEB-INF/
│           ├── css/
│           ├── analytics.jsp
│           ├── dashboard.jsp
│           ├── hashmapResult.jsp
│           ├── index.jsp
│           ├── login.jsp
│           ├── rank.jsp
│           ├── register.jsp
│           ├── search.jsp
│           └── searchResult.jsp
│
├── .gitignore
├── .classpath
├── .project
└── README.md
