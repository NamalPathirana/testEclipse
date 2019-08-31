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
<title>BasicSalaryView</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="css/test.css" rel="stylesheet" type="text/css">

</head>
<body>

<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#" id="navAnchor" >Home</a></li>
    <li class="breadcrumb-item active" ><a href="SalaryManagement.jsp" id="navAnchor">SalaryManagement</a></li>
  	<li class="breadcrumb-item active" aria-current="page">BasicSalaryView</li>
  </ol>
</nav>

<div id="alert">
<%if((Integer)session.getAttribute("rowsBS")!=null){%>
<%int rows=(Integer)session.getAttribute("rowsBS");%>
<%if(rows>0){%>
<div class="alert alert-danger alert-dismissible fade show" id="Alert" role="alert">
<p id="error">success. <%=rows%> rows Deleted <p>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</div>
<%
session.setAttribute("rowsBS", null);
}
else{%>

<div class="alert alert-danger alert-dismissible fade show" id="Alert" role="alert">
<p id="error">error. <%=rows%> rows effected.entry may exist </p>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</div>
<%
session.setAttribute("rowsBS", null);
}%>

<%}%>

</div>


<div style="width:1200px; margin-left:auto; margin-right:auto;" class="container" id="veiwTable">

<table  class="table table-striped">

<%

BasicSalaryServiceImp allprom=new BasicSalaryServiceImp();

/* request.setAttribute("Allpost",allot.getAll()); */

List <BasicSalary> otl=allprom.getAllBasicSalary();



%>


<tr >
	<th scope="col">Position</th>
	<th scope="col">Date</th>
	<th scope="col">BasicSalary</th>
	<th scope="col"></th>
	<th scope="col"></th>
</tr>	

<c:forEach items="<%=otl%>" var="OT"><%-- important use<= not ${ for variables.'${' used for request obj retrieves --%>

<tr>

<th scope="row">${OT.postion}</th>
<td>${OT.date}</td>
<td>${OT.basicsalary}</td>

<td>
	<button class="btn btn-success btn-sm btn-block" type="button" ><a href="updateBasicSalary.jsp?position=${OT.postion}&date=${OT.date}">Update</a></button>
</td>

<td>
	<button class="btn btn-danger btn-sm " type="button" ><a href="deleteBasicSalary?position=${OT.postion}">delete</a></button>
</td>


</tr>

</c:forEach>





</table>




</div>



<div id="scripts">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</div>







</body>
</html>