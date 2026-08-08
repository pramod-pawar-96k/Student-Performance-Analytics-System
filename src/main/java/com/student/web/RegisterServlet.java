package com.student.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.model.Student;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ✅ HANDLE GET REQUEST (OPEN REGISTER PAGE)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    // ✅ HANDLE POST REQUEST (FORM SUBMISSION)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollNo = request.getParameter("rollNo");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        int physics = Integer.parseInt(request.getParameter("physics"));
        int chemistry = Integer.parseInt(request.getParameter("chemistry"));
        int maths = Integer.parseInt(request.getParameter("maths"));

        // 🔒 SERVER-SIDE VALIDATION
        if (physics < 0 || physics > 100 ||
            chemistry < 0 || chemistry > 100 ||
            maths < 0 || maths > 100) {

            request.setAttribute("error", "Marks must be between 0 and 100");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        int total = physics + chemistry + maths;

        // ✅ MATCHES Student.java CONSTRUCTOR
        Student student = new Student(
                rollNo, name, password,
                physics, chemistry, maths, total
        );

        StudentDAO dao = new StudentDAO();
        dao.registerStudent(student);

        // ✅ REDIRECT TO LOGIN PAGE
        response.sendRedirect("login.jsp");
    }
}
