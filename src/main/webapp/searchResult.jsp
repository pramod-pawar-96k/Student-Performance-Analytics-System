<%@ page import="com.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Result</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Search Result</h2>

    <%
        Student s = (Student) request.getAttribute("student");
        if (s == null) {
    %>
        <p style="color:red; text-align:center; font-weight:600;">
            Student not found
        </p>
    <%
        } else {
    %>

    <table class="styled-table">
        <tr>
            <th>Roll No</th>
            <th>Name</th>
            <th>Total</th>
            <th>Average</th>
            <th>Grade</th>
            <th>Result</th>
        </tr>
        <tr>
            <td><%= s.getRollNo() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getTotal() %></td>
            <td><%= String.format("%.2f", s.getAverage()) %></td>
            <td><%= s.getGrade() %></td>
            <td><%= s.getResult() %></td>
        </tr>
    </table>

    <%
        }
    %>

    <br>
    <div style="text-align:center;">
        <a href="search.jsp">Back to Search</a>
    </div>
</div>

</body>
</html>
