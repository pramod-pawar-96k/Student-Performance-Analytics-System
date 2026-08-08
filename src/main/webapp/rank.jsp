<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Rank List</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<div class="container rank-page">

    <h2 class="title">Student Rank List</h2>

    <table class="rank-table">
        <thead>
            <tr>
                <th>Rank</th>
                <th>Roll No</th>
                <th>Name</th>
                <th>Total</th>
                <th>Average</th>
                <th>Grade</th>
                <th>Result</th>
                <th>Best Subject</th>
                <th>Weak Subject</th>
            </tr>
        </thead>

        <tbody>
        <%
            int rank = 1;
            List<com.student.model.Student> list =
                (List<com.student.model.Student>) request.getAttribute("students");

            if (list != null && !list.isEmpty()) {
                for (com.student.model.Student s : list) {
        %>
            <tr>
                <td><%= rank++ %></td>
                <td><%= s.getRollNo() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getTotal() %></td>
                <td><%= String.format("%.2f", s.getAverage()) %></td>
                <td><%= s.getGrade() %></td>
                <td><%= s.getResult() %></td>
                <td><%= s.getBestSubject() %></td>
                <td><%= s.getWeakSubject() %></td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

    <div class="back-link">
        <a href="dashboard.jsp">Back to Dashboard</a>
    </div>

</div>
</body>
</html>
