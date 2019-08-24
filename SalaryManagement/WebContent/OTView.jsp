<%@page import="com.Salary.model.OT"%>
<%@page import="java.util.List"%>
<%@page import="com.Salary.service.OTServiceImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>   
 
 <%@ page import ="com.Salary.service.IOTServiceImp" %>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div style="width:1200px; margin-left:auto; margin-right:auto;">

<table cellpadding="10">

<%

IOTServiceImp allot=new OTServiceImp();

/* request.setAttribute("Allpost",allot.getAll()); */

List <OT> otl=allot.getAll();


%>



<tr>
	<th>Employee ID</th>
	<th>Date</th>
	<th>OT Hours</th>
</tr>	

<c:forEach items="<%=otl%>" var="OT"><%-- important use<= not ${ for variables.'${' used for request obj retrieves --%>

<tr>

<td>${OT.empID}</td>
<td>${OT.date}</td>
<td>${OT.hours}</td>

<td>
	<a href="edit?id=${OT.empID}&date=${OT.date}">Update</a>
</td>

<td>
	<a href="delete?id=${OT.empID}&date=${OT.date}">delete</a>
</td>


</tr>
</c:forEach>





</table>




</div>

</body>
</html>