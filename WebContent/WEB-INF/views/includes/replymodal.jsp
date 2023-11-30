<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="replyModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">댓글</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form>
					<input type="hidden" id="userno" name="userno" value="${member.userno}">
					<input type="hidden" name="bno" value="${board.bno}">
					<div class="form-group">
						<label for="userno">작성자</label>
						<input class="form-control" id="nickname" name="nickname" value="${member.nickname}">
					</div>
					<div class="form-group">
						<label for="comment">내용</label>
						<input class="form-control" id="comment" name="comment">
					</div>
					<div class="form-group">
						<label for="regDate">등록일</label>
						<input class="form-control" id="regDate" name="regDate">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-warning" type="button">수정</button>
				<button class="btn btn-danger" type="button">삭제</button>
				<button class="btn btn-primary" type="button">등록</button>
				<button class="btn btn-secondary" type="button" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

