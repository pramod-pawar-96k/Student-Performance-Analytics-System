package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.student.model.Student;

public class StudentDAO {

// Database configuration:
// Update these values with your local MySQL database details before running the project.
private String jdbcURL = "jdbc:mysql://localhost:3306/student_db";
private String jdbcUsername = "root";
private String jdbcPassword = "your_mysql_password";
    private static final String INSERT_STUDENT_SQL =
        "INSERT INTO students " +
        "(roll_no, name, password, physics, chemistry, maths, total) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";

    // ✅ REGISTER STUDENT (WITH MARKS)
    public void registerStudent(Student student) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);

            PreparedStatement ps = conn.prepareStatement(INSERT_STUDENT_SQL);

            ps.setString(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setString(3, student.getPassword());
            ps.setInt(4, student.getPhysics());
            ps.setInt(5, student.getChemistry());
            ps.setInt(6, student.getMaths());
            ps.setInt(7, student.getTotal());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ LOGIN VALIDATION (ONLY ROLL + PASSWORD)
    public boolean validateStudent(String rollNo, String password) {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "SELECT * FROM students WHERE roll_no=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, rollNo);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ✅ FETCH STUDENTS FOR RANKING / SEARCH / ANALYTICS
    public List<Student> getAllStudentsWithMarks() {

        List<Student> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "SELECT roll_no, name, physics, chemistry, maths, total FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student(
                        rs.getString("roll_no"),
                        rs.getString("name"),
                        rs.getInt("physics"),
                        rs.getInt("chemistry"),
                        rs.getInt("maths"),
                        rs.getInt("total")
                );
                list.add(s);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public Map<String, Student> getStudentMap() {

        Map<String, Student> map = new HashMap<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "SELECT * FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student(
                    rs.getString("roll_no"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getInt("physics"),
                    rs.getInt("chemistry"),
                    rs.getInt("maths"),
                    rs.getInt("total")
                );
                map.put(s.getRollNo(), s); // 🔥 KEY POINT
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

}
