<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.accountImpl.AccountImpl,com.accnovalidation.ValidAccNo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display sq</title>
</head>
<body>
<%  

String ap=(String)session.getAttribute("nav");
System.out.println(ap);

%>

</body>
</html>