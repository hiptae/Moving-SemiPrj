<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Page Title</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.min.js"></script>
    <script src="https://unpkg.com/youtube-background@1.0.14/jquery.youtube-background.min.js"></script>
</head>
<!-- 바디 -->
<body>
	<!-- 헤더 -->
  	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="py-5">
	    <div class="container-fluid bg-dark bg-gradient text-white text-center pt-5">
	        <div class="container">
	            <div class="row align-items-end">
	            <div class="col-lg-3">
	                <a href="${cp}/movie?m=${movie.mno}">
	                    <img alt="${movie.title}" src="${image.backdroppath}">
	                </a>
	                </div>
	                <div class="col-lg-6" >
	                <div class="text-start">
	                        <c:set var="year" value="${fn:substring(movie.formattedMdate, 0, 4)}" />
	                        <h2><a class="text-white" href="${cp}/movie?m=${movie.mno}">${movie.title}</a> <span class="h4">(${year})</span></h2>
	                        <div><a class="text-white" href="${cp}/movie?m=${movie.mno}">← 영화로 돌아가기</a></div>
	                </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="container-fluid bg-light text-black pt-5">
	<div class="container">
		<section class="row align-items-start">
			<div class="col-6">
				<div class="py-3">
					<h3>배역 <span class="h5">${actors}</span></h3>
				</div>
				<ul class="list-unstyled">
					<c:forEach items="${castList}" var="cast">
					<c:set var="image" value="${cast.profileImage}" />
					<c:choose>
					    <c:when test="${image != null}">
					        <c:set var="imagePath" value="https://image.tmdb.org/t/p/w66_and_h66_face${image}" />
					    </c:when>
					    <c:otherwise>
					        <c:set var="imagePath" value="https://via.placeholder.com/66x66" />
					    </c:otherwise>
					</c:choose>
					<li class="row align-items-end py-1">
						<a class="col-auto" href="#"><img class="rounded" alt="${cast.name}" src="${imagePath}"></a>
						<div class="col-auto">
							<div>
								<b>${cast.casting}</b>
								<p>${cast.name}</p>
							</div>
						</div>
					</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-6">
				<div class="py-3">
					<h3>제작진 <span class="h5">${crews}</span></h3>
				</div>
				<div>
					<c:forEach var="casttype" items="${groupedCasts}">
						<c:if test="${not empty casttype.value}">
							<h5 class="pt-3">${casttype.key}</h5>
							<ul class="list-unstyled">
								<c:forEach var="cast" items="${casttype.value}">
									<c:set var="image" value="${cast.profileImage}" />
									<c:choose>
									    <c:when test="${image != null}">
									        <c:set var="imagePath" value="https://image.tmdb.org/t/p/w66_and_h66_face${image}" />
									    </c:when>
									    <c:otherwise>
									        <c:set var="imagePath" value="https://via.placeholder.com/66x66" />
									    </c:otherwise>
									</c:choose>
									<li class="row align-items-end py-1">
										<a class="col-auto" href="#"><img class="rounded" alt="${cast.name}" src="${imagePath}"></a>
										<div class="col-auto">
											<div>
												<b>${cast.casting}</b>
												<p>${cast.name}</p>
											</div>
										</div>
									</li>
								</c:forEach>
							</ul>
						 </c:if>
					</c:forEach>
				</div>
			</div>
		</section>
	</div>
	</div>
	<!-- Footer -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>