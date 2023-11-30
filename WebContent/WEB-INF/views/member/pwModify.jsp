<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>비밀번호 변경</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/style.css">
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
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
 </head>
    <!-- 바디 -->
    <body>
        <!-- 헤더 -->
        <jsp:include page="../includes/header.jsp"></jsp:include>
        
        <div class="container my-5">
            <div class="row justify-content-center align-items-center vh-80">
                <div class="col-md-5">
                    <h2 class="mb-4 text-center">기본정보</h2>
                    <div class="card p-4 border border-3 rounded-5">
                        <form method="post">
                            <div class="col-10 mb-2 mx-auto">
                                <i class="fas fa-key mx-1"></i>
                                <label class="form-label fs-7 text-muted-50 fst-italic" for="loginPassword">비밀번호</label>
                                <input type="password" class="form-control p-1" name="oldpassword" id="password" >
                            </div>
                            <div class="col-10 mb-2 mx-auto">
                                <i class="fas fa-key mx-1"></i>
                                <label class="form-label fs-7 text-muted-50 fst-italic" for="loginPassword">새로운 비밀번호</label>
                                <input type="password" class="form-control p-1" name="password" id="password"  pattern="^[a-zA-Z0-9!@]{4,10}$" >
                            </div>
                            <div class="col-10 mb-4 mx-auto pb-2">
                              <i class="fas fa-check-circle mx-1"></i>
                                <label class="form-label fs-7 text-muted-50 fst-italic"
                                    for="loginPassword">비밀번호 확인</label>
                                <input type="password" class="form-control p-1" name="passwordchk" id="password"  pattern="^[a-zA-Z0-9!@]{4,10}$" >
                            </div> 
                            <div class="col-10 mb-2 mx-auto">
                                <input type="hidden" name="myMember" value="<%=request.getAttribute("myMember") %>">
                                <button type="submit" id="joinBtn" class="form-control p-1">회원정보 수정하기</button>
                            </div>
                        </form>
                    </div>
                 </div>
            </div>
        </div>
        
        <!-- 푸터 -->
        <jsp:include page="../includes/footer.jsp"></jsp:include>

    </body>
</html>