<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
<meta name ="viewport" content ="width=device-width, initial-scale=1.0">
</head>
<body >

<jsp:include page="header.jsp" />  

<div class="loginSignupFlexContainer">


<form:form method = "POST" action = "/signup/adduser" modelAttribute = "user" class="loginSignupFlexItem">

<label> Frist Name: </label> <form:input path = "firstName" required = "true"  /><br> 

<label> Last Name: </label>  <form:input path = "lastName" required = "true" /><br> 

<label> Username:</label>  <form:input path = "username" required = "true"  /><br> 
<label> Password: </label> <form:password path = "password" required = "true" /><br> 

 <label>Email:  </label><form:input path = "email" required = "true" /><br> 

<label>  Phone Number:</label> <form:input path = "phone" required = "true" /><br> 

<p> </p>

<input type ="submit" value ="SIGN UP" class= "formSubmit"/>


</form:form>

</div>


</body>
</html>