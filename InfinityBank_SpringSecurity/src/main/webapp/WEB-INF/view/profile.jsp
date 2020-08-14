<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profile</title>

<link href="${pageContext.request.contextPath}/resources/profile.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/internalHeader.css" rel="stylesheet"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<!-- Desktop Nav Bar -->

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
	
	
	
	<!-- Body Content -->

	<div class="content">

		<h1>Welcome ${User.getUsername() }</h1>
		<br>


		<div class="flexContainer">

			<div class="box flexItem">

				<h2>Primary Account</h2>
				<br>
				<h3>Account Number: <span class="highlight">${ User.getPrimaryAccount().getAccountNumber()}</span> 
				</h3>
				<br>
				<h3>Account Balance: <span class="highlight">  ${User.getPrimaryAccount().getBalance()}</span></h3>
				<br>
				<form:form method="POST"
					action="${request.getContextPath()}/primaryTransaction"
					modelAttribute="ProfileUserId" class="transactionHistoryForm">
					<form:hidden path="userId" value="${User.getUserId()}" />
					<input type="submit" value="Primary Transaction History"
						class="button" />
				</form:form>
			</div>



			<div class="box flexItem">

				<h2>Savings Account</h2>
				<br>

				<h3>Account Number:<span class="highlight">
					${User.getSavingsAccount().getAccountNumber()}</span></h3>
				<br>
				<h3>Account Balance:<span class="highlight"> ${User.getSavingsAccount().getBalance() }</span>
				</h3>
				<br>
				<form:form method="POST"
					action="${request.getContextPath()}/savingsTransaction"
					modelAttribute="ProfileUserId" class="transactionHistoryForm">
					<form:hidden path="userId" value="${User.getUserId()}" />
					<input type="submit" value="Savings Transaction History"
						class="button" />
				</form:form>
			</div>



		
		</div>



	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	
	<script src="${pageContext.request.contextPath}/resources/internalHeader.js"></script>

</body>
</html>