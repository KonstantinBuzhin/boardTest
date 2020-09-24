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



	<div class="container">
		<button type="button"
			onclick="window.location='/BulletinBoard/personalCabinet';">Personal
			Cabinet</button>
		<br>
		<c:if test="${access eq 'Successfully logged'}">

			<c:if test="${(updating eq 'active')}">
				<h3>Ваш аккаунт успешно обновлён.</h3>
			</c:if>

			<label for="uname"><b>First name:</b></label>
			<br>
			<input type="text" placeholder="Enter First name" name="firstName"
				id="firstName" value="${firstName }">
			<br>
			<label for="uname"><b>Last name:</b></label>
			<br>
			<label id="lastName">${lastName }</label>
			<br>
			<label for="uname"><b>Email:</b></label>
			<br>
			<input type="text" placeholder="Enter Email" name="email" id="email"
				value="${email }" required>
			<br>
			<label for="psw"><b>Password:</b></label>
			<br>
			<input type="password" placeholder="Enter Password" name="password"
				id="password" value="" required>
			<br>
			<button type="button" onclick="editProfile();">Confirm</button>
			<br>

		</c:if>
		<c:if test="${!(access eq 'Successfully logged')||(access == null)}">
			<button type='button'
				onclick="window.location='/BulletinBoard/login'">Sign in</button>

		</c:if>


	</div>
	<script src="<c:url value='/resources/js/jquery.js' />"></script>
	<script>
		function editProfile() {
			var name = document.getElementById('firstName').value;
			var email = document.getElementById('email').value;
			var password = document.getElementById('password').value;
			if (name.length != 0 && email.length != 0 && password.length != 0) {
				$.ajax({
					url : 'editing',
					type : 'post',
					data : {
						firstName : name,
						email : email,
						password : password,
					},
					success : function(data) { // вешаем свой обработчик на функцию success
						window.location.href = '/BulletinBoard/editing';
					}

				})
			} else {
				alert("Write in all of the lines");
			}
		}
	</script>
</body>

</html>
