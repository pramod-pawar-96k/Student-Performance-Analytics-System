<!DOCTYPE html>
<html>
<head>
    <title>Class Performance Analytics</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">

    <h2>Class Performance Analytics</h2>

    <!-- OVERALL STATS -->
    <div class="info-box">
        <p><strong>Class Average:</strong> ${classAverage}</p>
        <p><strong>Pass Percentage:</strong> ${passPercentage}%</p>
        <p><strong>Fail Percentage:</strong> ${failPercentage}%</p>
    </div>

    <hr>

    <!-- TOPPER -->
    <h3> Topper</h3>
    <p>
        ${topper.name} (Roll No: ${topper.rollNo}) — 
        <strong>${topper.total}</strong>
    </p>

    <hr>

    <!-- WEAKEST -->
    <h3> Weakest Student</h3>
    <p>
        ${weakest.name} (Roll No: ${weakest.rollNo}) — 
        <strong>${weakest.total}</strong>
    </p>

    <hr>

    <!-- SUBJECT AVERAGES -->
    <h3> Subject-wise Average</h3>
    <ul class="subject-list">
        <li><strong>Physics:</strong> ${physicsAvg}</li>
        <li><strong>Chemistry:</strong> ${chemistryAvg}</li>
        <li><strong>Maths:</strong> ${mathsAvg}</li>
    </ul>

    <br>
    <a href="dashboard.jsp" class="btn">Back to Dashboard</a>

</div>

</body>
</html>
