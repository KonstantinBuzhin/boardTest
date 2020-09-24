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
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/listAds.css' />">
</head>

<header>

	<div class="tabs">
		<div class="tab">
			<input type="radio" id="tab1" name="tab-group" disabled checked>
			<label for="tab1" class="tab-title">Homepage</label>
			<section class="tab-content">
				<button type='button'
					onclick="window.location='/BulletinBoard/login'">Sign in</button>
				<button type='button'
					onclick="window.location='/BulletinBoard/registration'">Sign
					up</button>
				<br>

				<c:forEach items="${listAds}" var="ad">
					<div class="col-md-12 blog-post-item-list">
						<div class="blog-post-item v2">
							<div class="blog-post-info">

								<h3 class="post-name ">
									<a>${ad.title}</a>
								</h3>
								<c:if test="${!(ad.image == null)}">

									<img style="max-height: 250px; max-width: 250px;"
										src="./imageOut?number=${ad.idAd }">
								</c:if>

								<p>${ad.textDescription}</p>

								<div>
									<div class="post-date">${ad.dateAdding}|${ad.timeAdding }</div>
									<div class="post-date">${ad.idUser.lastName }</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

				<div class="pagination">
					<c:forEach items="${quantityPages}" var="numberPage">
						<c:if test="${numberPage eq '1'}">
							<a <c:if test="${param['page'] == null}">class="active"</c:if>
								href="/BulletinBoard">${numberPage}</a>
						</c:if>
						<c:if test="${!(numberPage eq '1')}">

							<a
								<c:if test="${numberPage eq currentPage}">class="active"</c:if>
								href="/BulletinBoard?page=${numberPage}">${numberPage}</a>
						</c:if>
					</c:forEach>
					<c:if test="${lastPage == null}">
						<a href="/BulletinBoard?page=${currentPage+1}">&raquo;</a>
					</c:if>
					<c:if test="${lastPage eq 'lastPage'}">
						<a>&raquo;</a>
					</c:if>
				</div>
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
