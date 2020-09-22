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
	href="<c:url value='/resources/css/tabs.css' />">
	<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css' />">
</head>

<header>

	<div class="tabs">
		<div class="tab">
			<input type="radio" id="tab1" name="tab-group" disabled checked>
			<label for="tab1" class="tab-title">Homepage</label>
			<section class="tab-content">
				<button type='button' onclick="window.location='/BulletinBoard/login'">Sign in</button>
				<button type='button' onclick="window.location='/BulletinBoard/registration'">Sign up</button>
			</section>

		</div>
		<div class="tab">
			<input type="radio" id="tab2" name="tab-group"
				onclick="window.location='/BulletinBoard/personalCabinet';"><label
				for="tab2" class="tab-title">Personal Cabinet</label>

		</div>
	</div>

</header>

</html>
