<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>

<!DOCTYPE html>
<html>
<style>
    body { font-family: 굴림체; }
    table.table { width: 500px; }
    table td:nth-child(1) { background-color: #eee; }
    h1 {
        margin-top: 30px;
        margin-bottom: 20px;
    }
</style>
<body>

<div class="container">

    <h1>댓글 목록</h1>
    <table class="table table-hover table table-striped">
        <tr>
            <th>댓글번호</th>
            <th>작성자</th>
            <th>내용</th>
            <th>작성시간</th>
            <th>삭제</th>
        </tr>

        <c:forEach items="${comment}" var="comment">
            <form action="/post/${comment.getPostId()}/comment/${comment.getCommentId()}" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <tr>
                    <th>${comment.getCommentId()}</th>
                    <th>${comment.getUsername()}</th>
                    <th><a href="http://localhost:8080">${comment.getContent()}</a></th>
                    <th>${comment.getCreatedTime()}</th>
                    <th><button type="submit" class="btn btn-primary">삭제</button></th>
                </tr>
            </form>
        </c:forEach>
    </table>

    <a href="/post/${postId}/return?check=1" class="btn btn-info">게시글 보러가기</a>
    <a href="javascript:window.history.back()" class="btn btn-info">뒤로가기</a>
</div>

<div class="container">
    <h1>댓글 등록</h1>
    <form action="/post/${postId}/comment" method="POST">
        <table class="table table-bordered table-condensed">
            <tr>
                <td class="mid">댓글</td>
                <td>
                    <label>
                        <textarea class="form-control" name="content" rows="4" required></textarea>
                    </label>
                </td>
            </tr>
        </table>
        <button type="submit" class="btn btn-primary">등록</button>
    </form>
</div>

</body>
</html>