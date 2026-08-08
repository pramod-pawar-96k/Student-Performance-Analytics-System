package com.student.web;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.model.Student;

@WebServlet("/rank")
public class MarksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 🔥 HASHMAP FOR O(1) SEARCH
    public static Map<String, Student> studentMap = new HashMap<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudentsWithMarks();

        // 🔹 Fill HashMap
        studentMap.clear();
        for (Student s : students) {
            studentMap.put(s.getRollNo(), s);
        }

        // 🔹 SORT for Ranking
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s2.getTotal() - s1.getTotal();
            }
        });

        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("rank.jsp");
        rd.forward(request, response);
    }
}
