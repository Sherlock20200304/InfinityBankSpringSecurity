<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
<meta name ="viewport" content ="width=device-width, initial-scale=1.0">
</head>
<body >

<jsp:include page="header.jsp" />  


<div class="loginSignupFlexContainer">
<form method = "POST" action = "/login" id = "form" class="loginSignupFlexItem">

<label> Username: </label> <input type = "text" name = "username" required = "true" /><br> 

<label> Password:  </label><input type ="password" name = "password" required = "true"  /><br> 

  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

           

<p> </p>

<input type ="submit" value ="LOGIN" class= "formSubmit"/>


</form>

</div>


</body>
</html>