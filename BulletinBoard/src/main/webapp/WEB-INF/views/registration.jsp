<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>Bulletin Board</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css' />">
</head>
<body>

	<form action="/BulletinBoard/registration" method="post">

		<div class="container">
			<label for="uname"><b>First name:</b></label><br> <input
				type="text" placeholder="Enter First name" name="firstName" required><br>
			<label for="uname"><b>Last name:</b></label><br> <input
				type="text" placeholder="Enter Last name" name="lastName" required><br>
			<label for="uname"><b>Email:</b></label><br> <input type="text"
				placeholder="Enter Username" name="email" required><br>
			<label for="psw"><b>Password:</b></label><br> <input
				type="password" placeholder="Enter Password" name="password"
				required><br>

			<button type="submit">Registration</button>



		</div>



	</form>
</body>

</html>
