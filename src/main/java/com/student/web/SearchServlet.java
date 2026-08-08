package com.student.web;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.student.dao.StudentDAO;
import com.student.model.Student;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollNo = request.getParameter("rollNo");
        String type = request.getParameter("type");

        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudentsWithMarks();

        Student result = null;

        // ================= LINEAR SEARCH =================
        if ("linear".equals(type)) {

            for (Student s : students) {
                if (s.getRollNo().equals(rollNo)) {
                    result = s;
                    break;
                }
            }

        // ================= BINARY SEARCH =================
        } else if ("binary".equals(type)) {

            Collections.sort(students,
                    Comparator.comparing(Student::getRollNo));

            int low = 0, high = students.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                Student s = students.get(mid);

                int cmp = s.getRollNo().compareTo(rollNo);

                if (cmp == 0) {
                    result = s;
                    break;
                } else if (cmp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        // ================= HASHMAP SEARCH (O(1)) =================
        } else if ("hash".equals(type)) {

            Map<String, Student> map = new HashMap<>();

            for (Student s : students) {
                map.put(s.getRollNo(), s);
            }

            result = map.get(rollNo); // 🔥 O(1)
        }

        request.setAttribute("student", result);
        request.getRequestDispatcher("searchResult.jsp")
               .forward(request, response);
    }
}
