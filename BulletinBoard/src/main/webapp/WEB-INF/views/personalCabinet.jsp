<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bulletin Board</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/tabs.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css' />">
</head>

<header>
	<c:set var='access' value="${sessionScope.access}" />
	<div class="tabs">
		<div class="tab">
			<input type="radio" id="tab1" name="tab-group"
				onclick="window.location='/BulletinBoard';"> <label
				for="tab1" class="tab-title">Homepage</label>


		</div>
		<div class="tab">
			<input type="radio" id="tab2" name="tab-group" disabled checked><label
				for="tab2" class="tab-title">Personal Cabinet</label>
			<section class="tab-content">
				<c:if test="${access eq 'Successfully logged'}">
					<button type='button'
						onclick="window.location='/BulletinBoard/editing'">Edit
						Profile</button>
					<button type='button'
						onclick="window.location='/BulletinBoard/adding'">Add an
						ad</button>
					<button type='button' onclick="logout();">Logout</button>
				</c:if>
				<c:if test="${!(access eq 'Successfully logged')||(access == null)}">
					<button type='button'
						onclick="window.location='/BulletinBoard/login'">Sign in</button>

				</c:if>
			</section>
		</div>
	</div>

</header>

<body>
	<script src="<c:url value='/resources/js/jquery.js' />"></script>
	<script>
		function logout() {

			$.ajax({
				url : '/BulletinBoard/login',
				type : 'post',
				data : {
					logout : 'logout',
				},
				success : function(data) { // вешаем свой обработчик на функцию success
					window.location.href = '/BulletinBoard/login';
				}

			})

		}
	</script>
</body>

</html>
