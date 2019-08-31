<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="css/test.css" rel="stylesheet" type="text/css">

<title>Update promotions</title>
</head>
<body>

<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#" id="navAnchor" >Home</a></li>
    <li class="breadcrumb-item active" ><a href="SalaryManagement.jsp" id="navAnchor">SalaryMangement</a></li>
    <li class="breadcrumb-item active" ><a href="PromotionsView.jsp" id="navAnchor">promotionsView</a></li>
  	<li class="breadcrumb-item active" aria-current="page">PromotionUpdateInterface</li>
  </ol>
</nav>


<div id="UpdateOT" class="container">


<h3 class="interfaceHeader">Update Promotion Information</h3>

<c:forEach items="${Update}" var="p">

<form action="edithandlerProm" method="post" >

 <div class="form-group form-group col-md-6"> 
EmployeeID:<br/>

<input type="text" value="${p.empId}" name="empId" class="form-control" readonly><br/>
</div>

 <div class="form-group form-group col-md-6">

name:<br/>
<input type="text" name="name" style="width:200px"  value="${p.name}" class="form-control"  title="Enter the date in this format YYYY-MM-DD"   readonly><br/>
</div>

<div class="form-group form-group col-md-6">
date:<br/>
<input type="date" name="date" style="width:200px"  value="${p.date}" class="form-control"  title="Enter the date in this format YYYY-MM-DD"  ><br/>
</div>



 <div class="form-group form-group col-md-6">  
Promotion:<br/>
<input type="number" name="promotion" value="${p.promotion}" style="width:200px"  class="form-control"  title="" step="0.01" min="0" max="50000" required><br/>
</div>



<input type="submit" value="submit" id="OTsubmit" class="btn btn-primary">



</form><br/><br/>

</c:forEach>

<%
if(session.getAttribute("rowsProm")!=null){
%>
<p> ${rowsProm} is an in valid value .value range 0-50000</p>
<%
session.setAttribute("rowsProm",null);
}%> 
</div>

</div> 

<div id="response">

 








</body>
</html>