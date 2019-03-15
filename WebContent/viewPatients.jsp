<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bootstraplinks.html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Patients</h2>
<table class="table table-bordered" id="datatable" width="100%" cellspacing="0">
  <tr style="text-align:left">
    <th>Name</th>
    <th>Disease</th> 
  </tr>
 <c:forEach items="${patients}" var="patients">
		<tr>
		<td>${patients.name}</td>
		<td>${patients.disease}</td>
		</tr>
 </c:forEach>
</table>
</body>
</html>