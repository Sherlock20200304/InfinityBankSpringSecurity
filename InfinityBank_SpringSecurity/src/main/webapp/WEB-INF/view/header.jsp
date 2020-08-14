<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="${pageContext.request.contextPath}/resources/header.css"
	rel="stylesheet" />
</head>
<body>

	

	<div class="navBar">

		<a class="navItem" href="/"> HOME</a> 
		
		<a class="navItem"
			href="/login"> LOGIN </a>
			
			 <a class="navItem"
			href="/signup"> SIGN UP </a>

	</div>
	
	
	
	
	<img src="${pageContext.request.contextPath}/resources/burger.png"
		style="width: 40px" class="burger">
	
	
<div class="mobileBar">
		<a class="mobileNavItem" href="/"> HOME</a> 
		<a class="mobileNavItem"
			href="/login"> LOGIN </a> 
			<a class="mobileNavItem"
			href="/signup"> SIGN UP </a>

	</div>
	
	
	

	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	
	<script src="${pageContext.request.contextPath}/resources/header.js"></script>
</body>
</html>