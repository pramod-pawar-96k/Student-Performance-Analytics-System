package com.student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.student.model.Student;

@WebServlet("/hashmapSearch")
public class HashMapSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollNo = request.getParameter("rollNo");

        // 🔥 O(1) SEARCH
        Student student = MarksServlet.studentMap.get(rollNo);

        if (student != null) {
            request.setAttribute("student", student);
            RequestDispatcher rd =
                    request.getRequestDispatcher("hashmapResult.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error", "Student not found (HashMap Search)");
            RequestDispatcher rd =
                    request.getRequestDispatcher("hashmapSearch.jsp");
            rd.forward(request, response);
        }
    }
}
