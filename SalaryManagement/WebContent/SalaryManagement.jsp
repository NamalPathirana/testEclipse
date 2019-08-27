<%@page import="com.Salary.service.StaffTestServiceImp"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salary Management</title>

<link href="css/cssboot/⁩" rel="stylesheet" type="text/css" >
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="css/test.css" rel="stylesheet" type="text/css">

</head>
<body>

<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#" id="navAnchor">Home</a></li>
    <li class="breadcrumb-item active" aria-current="SalaryManagement">SalaryManagement</li>
  </ol>
</nav>

<div id="OTmanagemet" class="container" >

<h3 class="interfaceHeader"> Add OT </h3>

<%

 Date datetemp=new Date(System.currentTimeMillis());
 SimpleDateFormat dataFormat =new SimpleDateFormat("yyyy-MM-dd");
 String today =dataFormat.format(datetemp.getTime());	

 List ls;//for the emplyee names,ids
 StaffTestServiceImp st=new StaffTestServiceImp();
 
 ls=st.getEmpNames();
 
		 
%>



<form action="addot" method="post">

<div id="alert">
<%if((Integer)session.getAttribute("rowsOT")!=null){%>
<%int rows=(Integer)session.getAttribute("rowsOT");%>
<%if((Integer)session.getAttribute("rowsOT")>0){%>
<div class="alert alert-success alert-dismissible fade show" id="Alert" role="alert">
<p id="error">success.<%=rows%> rows effected</p>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</div>
<%
session.setAttribute("rowsOT", null);
}
else{%>

<div class="alert alert-danger alert-dismissible fade show" id="Alert" role="alert">
<p id="error">error. <%=rows%> rows effected.entry may exist </p>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</div>
<%
session.setAttribute("rowsOT", null);
}%>

<%}%>

</div>
<div class="form-row" style="background-color:redm">

<div class="form-group col-md-6">
<label>Employee ID:</label>
<select class="form-control col-form-label-sm " name="empId">
<c:forEach items="<%=ls%>" var="p">
<option  value="${p.empId}" >${p.name}</option>
</c:forEach>
</select>
</div>

<div class="form-group col-md-2.5">
<label>date:</label>
<input type="date" class="form-control col-form-label-sm" name="date" style="width:200px" value="<%=today%>" title="Enter the date in this format YYYY-MM-DD"  required><br/>
</div> 
 
<div class="form-group col-md-2"> 
<label>hours:</label>
<input type="text" class="form-control col-form-label-sm" name="hours" style="width:200px" placeholder="1" pattern="[1-4]{1}" title="1 to 4 hours" required><br/>
</div> 

</div>

<input type="submit"  value="submit" id="OTsubmit" class="btn btn-primary">

<button id="OTview" class="btn btn-success"><a href="OTView.jsp">Update & Delete</a></button>


</form><br/><br/>



</div>










<div id="promotionsManagement" class="container" >

<h3 class="interfaceHeader"> Add Promotions </h3>


<form action="addPromotions" method="post">

<div id="alert">
<%if((Integer)session.getAttribute("rowsPro")!=null){%>
<%int rows=(Integer)session.getAttribute("rowsPro");%>
<%if(rows>0){%>
<div class="alert alert-success alert-dismissible fade show" id="Alert" role="alert">
<p id="error">success.<%=rows%> rows effected</p>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</div>
<%
session.setAttribute("rowsPro", null);
}
else{%>

<div class="alert alert-danger alert-dismissible fade show" id="Alert" role="alert">
<p id="error">Error. <%=rows%> rows effected.Entry already exist.</p>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</div>
<%
session.setAttribute("rowsPro", null);
}%>

<%}%>

<%if(session.getAttribute("promError")!=null){%>   <!-- if promotions value exceeds the limitation -->

<div class="alert alert-warning alert-dismissible fade show" id="Alert" role="alert">
<p id="error">The promotion value should be between 0 and 50,000</p>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
<span aria-hidden="true">&times;</span>
</div>
<%
session.setAttribute("promError", null);
}
%>



</div>
<div class="form-row" style="background-color:redm">

<div class="form-group col-md-6">
<label>Employee :</label>
<select class="form-control col-form-label-sm " name="empId">
<c:forEach items="<%=ls%>" var="p">
<option  value="${p.empId}" >${p.name}</option>
</c:forEach>
</select>
</div>

<div class="form-group col-md-2.5">
<label>date:</label>
<input type="date" class="form-control col-form-label-sm" name="date" style="width:200px" value="<%=today%>" title="Enter the date in this format YYYY-MM-DD"  required><br/>
</div> 
 
<div class="form-group col-md-2"> 
<label>Promotion :</label>
<input type="text" class="form-control col-form-label-sm" name="promotion" style="width:200px" placeholder="promotion" title="Please enter a valid amount" required><br/>
</div> 

</div>

<input type="submit"  value="submit" id="OTsubmit" class="btn btn-primary">

<button id="OTview" class="btn btn-success"><a href="OTView.jsp">Update & Delete</a></button>


</form><br/><br/>



</div>








<div id="scripts">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</div>




</html>