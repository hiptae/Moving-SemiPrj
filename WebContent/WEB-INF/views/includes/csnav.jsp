<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String uri = request.getRequestURI();
%>
<div class="naw wrap p-0">
	<div class="my-5">
		<h2>고객센터</h2>
	</div>
	<div class="container">
		<ul class="nav nav-pills nav-fill py-2 navbar rounded-3 shadow-lg ">
        	<li class="nav-item"><a class="fw-bold fs-5 text-muted nav-link" aria-current="page"
           	 	href="/customer">공지사항</a></li>
        	<li class="nav-item"><a class="fw-bold fs-5 text-muted nav-link" aria-current="page"
           	 	href="/customer/faq">자주묻는질문 FAQ</a></li>
			<li class="nav-item"><a class="fw-bold fs-5 text-muted nav-link" aria-current="page"
				href="/customer/agreement">이용약관</a></li>
			<li class="nav-item"><a class="fw-bold fs-5 text-muted nav-link" aria-current="page"
				href="/customer/privacy">개인정보처리방침</a></li>
			<li class="nav-item"><a class="fw-bold fs-5 text-muted nav-link" aria-current="page"
				href="/customer/chat">1대1문의</a></li>
		</ul>
	</div>
</div>