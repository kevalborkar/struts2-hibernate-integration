<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<h3>Sorry Login Failed</h3>
	<p>UserName or Password is incorrect.</p>
	<p><a href="<s:url action='home' />">Return to home page</a>.</p>
</body>
</html>