<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container bg-light">
            <div class="row bg-light p-2">
                <div class="col">
                    <h3>쪽지함</h3>
                </div>
                <div class="col float-end">
                    <button class="btn btn-secondary">쪽지쓰기</button>
                </div>
                <div class="col float-end">
                    <button class="btn btn-secondary">선택삭제</button>
                </div>
                <div class="col float-end">
                    <button class="btn btn-secondary">닫기</button>
                </div>
            </div>
            <div class="row p-0">
                <ul class="p-0 list-group col-2">
                    <a href="" class="list-group-light list-group-item-action active px-3 border-0">받은 쪽지함</a>
                    <a href="" class="list-group-light list-group-item-action active px-3 border-0">보낸 쪽지함</a>
                </ul>
                <div class="col-10 ">
                    <div class="">
                    <!-- 쪽지 목록 -->
                        <ul class="list-group list-group-light mb-4">
                        	<c:forEach items="${receiList}" var="m">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <input class="col-1" type="checkbox">
                                <div class="col-4">${m.title}</div>
                                <div class="col-2">${m.fromnick}</div>
                                <div class="col-3">${m.regdate}</div>
                            </li>
                        	</c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
    </div>
    <script>
        $(function () {
            $.getJSON({})
        })
    </script>
</body>
</html>