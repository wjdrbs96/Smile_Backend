<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
    <style>
        body { font-family: 굴림체; }
        table.table { width: 500px; }
        table td:nth-child(1) { background-color: #eee; }
        h1 {
            margin-top: 30px;
            margin-bottom: 20px;
        }
    </style>
</head>
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
            <tr>
                <th>${comment.getCommentId()}</th>
                <th>${comment.getUsername()}</th>
                <th><a href="http://localhost:8080">${comment.getContent()}</a></th>
                <th>${comment.getCreatedTime()}</th>
                <th><a href="http://localhost:8080">삭제</a></th>
            </tr>
        </c:forEach>
    </table>

    <a href="http://localhost:8080/post/${postId}/return?check=1" class="btn btn-info">게시글 보러가기</a>
    <a href="javascript:window.history.back()" class="btn btn-info">뒤로가기</a>
</div>

<div class="container">
    <h1>댓글 등록</h1>
    <form action="http://localhost:8080/api/v1/post/${postId}/comment" method="POST">
        <table class="table table-bordered table-condensed">
            <tr>
                <td class="mid">댓글</td>
                <td>
                    <label>
                        <textarea class="form-control" name="content" rows="4"></textarea>
                    </label>
                </td>
            </tr>
        </table>
        <button type="submit" class="btn btn-primary">등록</button>
    </form>
</div>

</body>
</html>