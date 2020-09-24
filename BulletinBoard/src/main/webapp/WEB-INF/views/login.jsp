<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bulletin Board</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css' />">
</head>
<body>
	<header>
		<button type="button" onclick="window.location='/BulletinBoard';">Homepage</button>
	</header>

	<c:set var='show' value="${sessionScope.showForm}" />

	<c:if test="${(show eq 'true')|| (show eq null)}">

		<form action="/BulletinBoard/login" method="post">

			<div class="container">
				<label for="uname"><b>Email:</b></label><br> <input type="text"
					placeholder="Enter Username" name="email" value="${param['email']}"
					required><br> <label for="psw"><b>Password:</b></label><br>
				<input type="password" placeholder="Enter Password" name="password"
					required><br>

				<button type="submit">Login</button>


				<button style="float: right; background-color: #006400;"
					type="button"
					onclick="location.href = '/BulletinBoard/registration'">Registration</button>

				<br>

				<c:if test="${param['email']!=null}">

					<label for="uname">Error: Incorrect email or password</label>

				</c:if>

			</div>

		</form>

	</c:if>
</body>
</html>
