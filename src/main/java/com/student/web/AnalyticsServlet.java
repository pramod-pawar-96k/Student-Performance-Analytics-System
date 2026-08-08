package com.student.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.model.Student;

@WebServlet("/analytics")
public class AnalyticsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudentsWithMarks();

        int totalStudents = students.size();
        int passCount = 0;
        int failCount = 0;

        int totalMarksSum = 0;
        int physicsSum = 0;
        int chemistrySum = 0;
        int mathsSum = 0;

        Student topper = null;
        Student weakest = null;

        for (Student s : students) {

            totalMarksSum += s.getTotal();
            physicsSum += s.getPhysics();
            chemistrySum += s.getChemistry();
            mathsSum += s.getMaths();

            if ("Pass".equalsIgnoreCase(s.getResult()))
                passCount++;
            else
                failCount++;

            // Topper logic
            if (topper == null || s.getTotal() > topper.getTotal())
                topper = s;

            // Weakest logic
            if (weakest == null || s.getTotal() < weakest.getTotal())
                weakest = s;
        }

        double classAverage = totalStudents == 0 ? 0 : (double) totalMarksSum / totalStudents;
        double passPercentage = totalStudents == 0 ? 0 : (passCount * 100.0) / totalStudents;
        double failPercentage = totalStudents == 0 ? 0 : (failCount * 100.0) / totalStudents;

        double physicsAvg = totalStudents == 0 ? 0 : (double) physicsSum / totalStudents;
        double chemistryAvg = totalStudents == 0 ? 0 : (double) chemistrySum / totalStudents;
        double mathsAvg = totalStudents == 0 ? 0 : (double) mathsSum / totalStudents;

        // Send data to JSP
        request.setAttribute("classAverage", classAverage);
        request.setAttribute("passPercentage", passPercentage);
        request.setAttribute("failPercentage", failPercentage);
        request.setAttribute("topper", topper);
        request.setAttribute("weakest", weakest);
        request.setAttribute("physicsAvg", physicsAvg);
        request.setAttribute("chemistryAvg", chemistryAvg);
        request.setAttribute("mathsAvg", mathsAvg);

        RequestDispatcher rd = request.getRequestDispatcher("analytics.jsp");
        rd.forward(request, response);
    }
}
