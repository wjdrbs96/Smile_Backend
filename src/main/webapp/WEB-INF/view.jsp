<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <h1>게시글 보기</h1>

    <form action="/post/${post.getId()}" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
        <table class="table table-bordered table-condensed">
            <tr>
                <td>게시글 번호</td>
                <td>${post.getId()}</td>
            </tr>
            <tr>
                <td>글 제목</td>
                <td>
                    <label>
                        <textarea class="form-control" name="title" rows="1" readonly>${post.getTitle()}</textarea>
                    </label>
                </td>
            </tr>
            <tr>
                <td>글 내용</td>
                <td>
                    <label>
                        <textarea class="form-control" name="content" rows="10" readonly>${post.getContent()}</textarea>
                    </label>
                </td>
            </tr>
            <tr>
                <td>카테고리</td>
                <td><input type="text" value="${post.getCategory().getCategoryKorean()}" name="category" readonly/></td>
            </tr>
            <tr>
                <td>이미지</td>
                <td><img src="${post.getImagePath()}" alt="image"/></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>${post.getUsername()}</td>
            </tr>
            <tr>
                <td>작성시간</td>
                <td>${post.getCreatedTime()}</td>
            </tr>
        </table>

        <a class="btn btn-primary" href="/post/${post.getId()}/return?check=2">게시글 수정</a>
        <a href="/post/${post.getId()}/comment" class="btn btn-warning">댓글보기</a>
        <button type="submit" class="btn btn-warning">게시글 삭제</button>
        <a href="javascript:window.history.back()" class="btn btn-info">뒤로가기</a>
        <a href="/post" class="btn btn-info">처음으로</a>
    </form>
</div>
</body>
</html>