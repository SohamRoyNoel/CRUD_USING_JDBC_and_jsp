<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<td>ID</td>
<td>NAME</td>
<td>CITY</td>
</tr>
<c:forEach var="data" items="${res }">
<tr>
<td><c:out value="${data.id }"></c:out></td>
<td><c:out value="${data.name }"></c:out></td>
<td><c:out value="${data.city }"></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>