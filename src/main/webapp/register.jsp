<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

    <h2>Student Registration</h2>

    <% 
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p class="error"><%= error %></p>
    <% } %>

    <form action="register" method="post">

        <label>Roll No</label>
        <input type="text" name="rollNo" required>

        <label>Name</label>
        <input type="text" name="name" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <label>Physics Marks</label>
        <input type="number" name="physics" min="0" max="100" required>

        <label>Chemistry Marks</label>
        <input type="number" name="chemistry" min="0" max="100" required>

        <label>Maths Marks</label>
        <input type="number" name="maths" min="0" max="100" required>

        <input type="submit" value="Register">

    </form>

    <a href="index.jsp">Back to Home</a>

</div>

</body>
</html>
