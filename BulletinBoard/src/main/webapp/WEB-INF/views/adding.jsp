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

	<button type="button"
		onclick="window.location='/BulletinBoard/personalCabinet';">Personal
		Cabinet</button>
	<br>
	<c:if test="${access eq 'Successfully logged'}">

		<c:if test="${(creation eq 'made')}">
			<h3>Your ad is successfully added.</h3>
		</c:if>
		<c:if test="${!(creation eq 'made')}">

			<form action="/BulletinBoard/adding" method="post"
				enctype="multipart/form-data">

				<div class="container">
					<label for="uname"><b>Title:</b></label><br> <input
						type="text" placeholder="Enter Title" name="title"
						value="${param['title']}" required><br> <label
						for="uname"><b>Text description:</b></label><br> <input
						type="text" placeholder="Enter Text description"
						name="textDescription" value="${param['textDescription']}"
						required><br> <label for="uname"><b>Last
							name:</b></label><br> <input type="text" placeholder="Enter Last name"
						name="lastName" value="${param['textDescription']}" required><br>
					<input type="file" name="file" required />
					<button type="submit">Add</button>

				</div>

			</form>
		</c:if>
	</c:if>
	<c:if test="${!(access eq 'Successfully logged')||(access == null)}">
		<button type='button' onclick="window.location='/BulletinBoard/login'">Sign
			in</button>

	</c:if>
</body>

</html>
