<%@page import="Master.DTO.feedbackDTO"%>
<%@page import="Master.DTO.payDTO"%>
<%@page import="Master.DTO.customerDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Master.DAO.customerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<td>NAME</td>
<td>CITY</td>
<td>Price</td>
<td>Feedback</td>
</tr>
<%
	customerDAO cdao = new customerDAO();
	ArrayList results = cdao.join_3_tabels();
	Iterator itr = results.iterator();
	while(itr.hasNext()){
		customerDTO cdto =(customerDTO)itr.next();
		payDTO pdto = (payDTO)itr.next();
		feedbackDTO fdto = (feedbackDTO)itr.next();
%>
<tr>
<td><%= cdto.getName() %></td>
<td><%= cdto.getCity() %></td>
<td><%= pdto.getPRICE() %></td>
<td><%= fdto.getFEEDBACK() %></td>
</tr>
<%
	}
%>
</table>
</body>
</html>