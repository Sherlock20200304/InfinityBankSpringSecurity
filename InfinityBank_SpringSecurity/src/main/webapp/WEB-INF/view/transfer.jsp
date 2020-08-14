<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transfer</title>
<link href="${pageContext.request.contextPath}/resources/transaction.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/resources/internalHeader.css" rel="stylesheet"/>
<meta name ="viewport" content ="width=device-width, initial-scale=1.0">
</head>
<body >

<ul class="navBar">
		<li><form:form method="POST"
				action="${request.getContextPath()}/nav/home"
				modelAttribute="ProfileUserId" >
				<form:hidden path="userId" value="${User.getUserId()}" />
				<input type="submit" value="Home"  />
			</form:form></li>

		<li>Accounts
			<ul>
				<li><form:form method="POST"
						action="${request.getContextPath()}/primaryTransaction"
						modelAttribute="ProfileUserId" >
						<form:hidden path="userId" value="${User.getUserId()}" />
						<input type="submit" value="Primary Transaction History"
							 />
					</form:form></li>
				<li><form:form method="POST"
						action="${request.getContextPath()}/savingsTransaction"
						modelAttribute="ProfileUserId" >
						<form:hidden path="userId" value="${User.getUserId()}" />
						<input type="submit" value="Savings Transaction History"
							 />
					</form:form></li>
			</ul>

		</li>

		<li>Transactions
			<ul>
				<li><form:form method="POST"
						action="${request.getContextPath()}/transferBetweenAccounts"
						modelAttribute="ProfileUserId" >
						<form:hidden path="userId" value="${User.getUserId()}" />
						<input type="submit" value="Transfer"  />
					</form:form></li>
				<li><form:form method="POST"
						action="${request.getContextPath()}/ATM"
						modelAttribute="ProfileUserId" >
						<form:hidden path="userId" value="${User.getUserId()}" />
						<input type="submit" value="Deposit/Withdraw"  />
					</form:form></li>
			</ul>
		</li>

		<li><form method="post" action="/user/logout">

				<input type="hidden" name="status" value="destroy"> <input
					type="submit" value="logout">

			</form></li>

	</ul>

<!-- Mobile Navigation Bar -->
<img src="${pageContext.request.contextPath}/resources/burger.png"
		style="width: 40px" class="burger">
	

<ul class="mobileNavBar">
		<li class="mobileNavItem"><form:form method="POST"
				action="${request.getContextPath()}/nav/home"
				modelAttribute="ProfileUserId" >
				<form:hidden path="userId" value="${User.getUserId()}" />
				<input type="submit" value="Home"  />
			</form:form></li>

		
				<li class="mobileNavItem"><form:form method="POST"
						action="${request.getContextPath()}/primaryTransaction"
						modelAttribute="ProfileUserId" >
						<form:hidden path="userId" value="${User.getUserId()}" />
						<input type="submit" value="Primary Transaction History"
							 />
					</form:form></li>
				<li class="mobileNavItem"><form:form method="POST"
						action="${request.getContextPath()}/savingsTransaction"
						modelAttribute="ProfileUserId" >
						<form:hidden path="userId" value="${User.getUserId()}" />
						<input type="submit" value="Savings Transaction History"
							 />
					</form:form></li>
			

		

		
				<li class="mobileNavItem"><form:form method="POST"
						action="${request.getContextPath()}/transferBetweenAccounts"
						modelAttribute="ProfileUserId" >
						<form:hidden path="userId" value="${User.getUserId()}" />
						<input type="submit" value="Transfer"  />
					</form:form></li>
				<li class="mobileNavItem"><form:form method="POST"
						action="${request.getContextPath()}/ATM"
						modelAttribute="ProfileUserId" >
						<form:hidden path="userId" value="${User.getUserId()}" />
						<input type="submit" value="Deposit/Withdraw"  />
					</form:form></li>
			

		<li class="mobileNavItem"><form method="post" action="/user/logout">

				<input type="hidden" name="status" value="destroy"> <input
					type="submit" value="logout">

			</form></li>

	</ul>

<div class="flexContainer">


<div class="flexItem">
<h1 >Transfer</h1>
</div>


<div class="flexItem">
<form:form action ="${request.getContextPath()} /transferOperation" modelAttribute = "Info" method ="POST">

Transfer To: 

<form:select path="transferTo" required = "true">  
        <form:option value="primaryAccount" label="Primary Account"/>  
        <form:option value="savingsAccount" label="Savings Account"/>   
        </form:select> <br> 
        
Transfer From: <form:select path="transferFrom" required = "true">  
        <form:option value="primaryAccount" label="Primary Account"/>  
        <form:option value="savingsAccount" label="Savings Account"/>   
        </form:select> <br> 
        
Amount: <form:input path ="amount" required = "true"/><br>
<form:hidden path="userId" value = "${ProfileUserId.getUserId()} "/>

<input type = "submit" value ="Make transaction" class= "formSubmit"> 

</form:form>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	
	<script src="${pageContext.request.contextPath}/resources/internalHeader.js"></script>

</body>
</html>