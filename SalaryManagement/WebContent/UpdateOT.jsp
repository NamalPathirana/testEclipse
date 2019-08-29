<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OverTime update </title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="css/test.css" rel="stylesheet" type="text/css">


</head>
<body>

<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#" id="navAnchor" >Home</a></li>
    <li class="breadcrumb-item active" ><a href="SalaryManagement.jsp" id="navAnchor">SalaryMangement</a></li>
    <li class="breadcrumb-item active" ><a href="OTView.jsp" id="navAnchor">OverTimeView</a></li>
  	<li class="breadcrumb-item active" aria-current="page">UpdateTerminal</li>
  </ol>
</nav>


<div id="UpdateOT" class="container">


<h3 class="interfaceHeader">Update Over Time Information</h3>

<c:forEach items="${Update}" var="p">

<form action="editHandler" method="post" >

 <div class="form-group form-group col-md-6"> 
Employee ID:<br/>

<input type="text" value="${p.empID}" name="empId" class="form-control" readonly><br/>
</div>

 <div class="form-group form-group col-md-6">
date:<br/>
<input type="date" name="date" style="width:200px"  value="${p.date}" class="form-control"  title="Enter the date in this format YYYY-MM-DD"   readonly><br/>
</div>

 <div class="form-group form-group col-md-6">  
hours:<br/>
<input type="text" name="hours" value="${p.hours}" style="width:200px" pattern="[1-4]{1}" class="form-control"  title="1 to 4 hours" required><br/>
</div>

<input type="submit" value="submit" id="OTsubmit" class="btn btn-primary">



</form><br/><br/>

</c:forEach>

</div>

<div id="response">

<%
if((Integer)request.getAttribute("rows")!=null){
%>
<p> ${rows} rows effected</p>
<%
request.setAttribute("rows",null);
}%> 
</div> 


</body>
</html>