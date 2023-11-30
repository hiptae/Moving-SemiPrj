<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>로그인</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
  <!-- 헤더 -->
  <jsp:include page="../includes/header.jsp"></jsp:include>
	<section class="bg-image">
		<div class="container h-100">
	    	<div class="row justify-content-center align-items-center mt-5">
	        	<div class="col-md-6 my-5">
	            	<div class="card border-0 mt-5 p-3">
                        <h1 class="text-uppercase text-center mb-5">비밀번호 찾기</h1>
                            <div class="small mb-5">본인확인 이메일 주소와 입력한 이메일 주소가 같아야 임시비밀번호를 받을 수 있습니다.</div>
						 <form method="post">
                                
                                	<%-- 아이디 --%>
                                	<div id="useridFeedback"></div>
									<div class="col input-group border border-light rounded-3 mb-3">
	                                   <div class="form-floating">
	                                       <input type="text" class="form-control border-0"
	                                           id="userid" name="userid" placeholder="아이디" pattern="^[a-zA-Z][a-zA-Z0-9]{3,9}$" required>
	                                       <label for="userid" class="fst-italic"><i class="fas fa-user"></i> 아이디</label>
	                                   </div>
                                    </div>
                                    
   									<%-- 이메일 --%>
                                    <div class="invalid-feedback" id="emailFeedback">이메일이 일치하지 않습니다.</div>
                                    <div class="col input-group border border-light rounded-3 mb-5">
                                        <div class="form-floating">
                                            <input type="email" class="form-control border-0" 
                                                id="email" name="email" placeholder="이메일" required>
                                            <label for="email" class="fst-italic"><i class="fas fa-envelope"></i>
                                                이메일</label>
                                        </div>
	                                    <div class="col-2 text-center p-1">
                                            <button class="btn btn-sm border-secondary rounded-4 mt-2"
                                                type="button" id="emailVerifyBtn">Email 인증</button>
                                       </div>
                                    </div>
                                    
                                    
                                    <div class="d-grid gap-2">
                                        <button type="submit" id="sendPwdBtn"
                                            class="btn btn-outline-light btn-lg p-3 fs-5 fw-bold rounded-4 ">
                                            발급받기
                                        </button>
                                    </div>
                                </form>
	            	</div>
				</div>
	    	</div>
		</div> 
	</section>
      <!-- 푸터 -->
  <jsp:include page="../includes/footer.jsp"></jsp:include>  
  
</body>
 <script>

    $(function () {
    	/* 회원가입 */ 
		$("#sendPwdBtn").click(function () {
	        console.log("전송이벤트");
	        if($(".is-valid").length < 1) {
	            console.log("막음");
	            event.preventDefault();
	            return false;
	        }
	        $("#sendPwdBtn").submit();
	        console.log("전송");
	    })
    	

    /* 이메일 일치 확인 */
    $("#emailVerifyBtn").click(function () {
    	console.log("인증");
        const userid = $("#userid").val();
        const email = $("#email").val();
    	console.log(userid);
    	console.log(email);
        
        $.post("/member/pwdEmailCheck", { userid : userid, email: email }, function (data) {
        	if(data.available) {
        		console.log("일치")
                $("#emailFeedback").css("display", "none");
	            $("#email").removeClass("is-invalid").addClass("is-valid");
            }
        	else {
        	console.log("불일치")
        	console.log(data.available)
	            $("#emailFeedback").css("display", "inline-block");
	            $("#email").removeClass("is-valid").addClass("is-invalid");
            }
        })
        
    });
    
    });
    </script>
</html>