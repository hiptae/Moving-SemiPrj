<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>회원제 게시판 - 게시글 목록</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <style>
	.search-area form{width: 50%}
    </style>
</head>
<body>
	<!-- 헤더 -->
  <jsp:include page="../includes/header.jsp"></jsp:include>
    <main class="width-wrap signin">
    	<h2>채팅방</h2>
    	<p>발신자 : ${member.nickname}</p>
    	<ul>
    		<li></li>
    	</ul>
    	<h3>채팅</h3>
    	<div>
    	<textarea style="width: calc(100% - 1em); resize: none; padding: .5em; height: 300px" readonly="readonly"></textarea>
    	<form name="frm">
    		<input name="msg" style="width: calc(100% - 2px - 1em); padding: .5em ">
    	</form>
    	</div>
    </main>
    <script>
    	const id = '${member.userno}';
    
        const ws = new WebSocket("ws://localhost:8080/customer/chat/chatting");
        $(document.frm).submit(function() {
        	event.preventDefault();
        	const msg = $(this.msg).val()
        	ws.send(id + ":" + msg);
        	$(this.msg).val("").focus();
        })
        ws.onmessage = function(msg) {
        	console.log(msg);
        	$("textarea").val($("textarea").val() + "\n" +  msg.data)
        }
        
    </script>
	<!-- 푸터 -->
  <jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>