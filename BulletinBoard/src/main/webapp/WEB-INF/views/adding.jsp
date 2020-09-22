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

	<button type="button"
		onclick="window.location='/BulletinBoard/personalCabinet';">Personal
		Cabinet</button>
	<br>

	<form action="/BulletinBoard/adding" method="post">

		<div class="container">
			<label for="uname"><b>Title:</b></label><br> <input type="text"
				placeholder="Enter Title" name="title" required><br> <label
				for="uname"><b>Text description:</b></label><br> <input
				type="text" placeholder="Enter Text description"
				name="textDescription" required><br> <label for="uname"><b>Last
					name:</b></label><br> <input type="text" placeholder="Enter Last name"
				name="lastName" required><br>

			<button type="submit">Add</button>

		</div>



	</form>
</body>

</html>
