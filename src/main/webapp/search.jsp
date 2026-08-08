<!DOCTYPE html>
<html>
<head>
    <title>Search Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Search Student</h2>

    <form action="search" method="get">

        <label>Roll No</label>
        <input type="text" name="rollNo" required>

        <label>Search Type</label>
        <select name="type">
            <option value="linear">Linear Search</option>
            <option value="binary">Binary Search</option>
            <option value="hash">HashMap Search</option>
        </select>

        <input type="submit" value="Search">
    </form>

    <div style="text-align:center; margin-top:15px;">
        <a href="dashboard.jsp">Back to Dashboard</a>
    </div>
</div>

</body>
</html>
