<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salary Management</title>
</head>
<body>


<div class="OTmanagemet">

<h3 class="interfaceHeader">Add OT</h3>

<form action="addot" method="post">


Employee ID:<br/>
<input type="text" name="empid" required><br/>

date:<br/>
<input type="date" name="date" style="width:200px" value="2012-02-14" title="Enter the date in this format YYYY-MM-DD" pattern="([0-1][0-9][0-9][0-9]|20[0-1][0-5])-(0[0-9]|1[0-2])-([0-2][0-9]|3[0-1])" required><br/>
 
hours:<br/>
<input type="text" name="hours" style="width:200px" placeholder="0" pattern="[1-4]{1}" title="1 to 4 hours" required><br/>

<input type="submit" value="submit">

<a href="OTView.jsp">view</a>


</form>


</div>



</body>
</html>