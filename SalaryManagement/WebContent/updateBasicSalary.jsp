<%@page import="com.Salary.model.BasicSalary"%>
<%@page import="java.util.List"%>
<%@page import="com.Salary.service.BasicSalaryServiceImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="css/test.css" rel="stylesheet" type="text/css">


</head>
<body>

<div id="UpdateOT" class="container">



<%


BasicSalaryServiceImp bs =new BasicSalaryServiceImp();


String position=request.getParameter("position");



List<BasicSalary> ls=bs.getBasicSalaryById(position);




%>



<h3 class="interfaceHeader">Update BasicSalary Information</h3>

<c:forEach items="<%=ls%>" var="p">

<form action="editBasicSalary" method="post" >

<div class="form-group form-group col-md-6"> 

EmployeeID:<br/>

<input type="text" value="${p.postion}" name="position" class="form-control" readonly><br/>
</div>


<div class="form-group form-group col-md-6">
date:<br/>
<input type="date" name="date" style="width:200px"  value="${p.date}" class="form-control"  title="Enter the date in this format YYYY-MM-DD"  required><br/>
</div>



 <div class="form-group form-group col-md-6">  
Promotion:<br/>
<input type="number" name="basicSalary" value="${p.basicsalary}" style="width:200px"  class="form-control"  step="0.01" required><br/>
</div>



<input type="submit" value="submit" id="OTsubmit" class="btn btn-primary">



</form><br/><br/>

</c:forEach>

<%
if(session.getAttribute("rowsBS")!=null){
%>
<p> ${rowsProm} is an in valid value .value range 0-50000</p>
<%
session.setAttribute("rowsBS",null);
}%> 
</div>

</div> 

<div id="response">








</body>
</html>