-- Student Performance Analytics System
-- Database setup

CREATE DATABASE IF NOT EXISTS student_db;

USE student_db;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roll_no VARCHAR(20) UNIQUE,
    name VARCHAR(100),
    password VARCHAR(100),
    physics INT,
    chemistry INT,
    maths INT,
    total INT
);