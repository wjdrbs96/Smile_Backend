<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/res/css/application.css" rel="stylesheet">
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

    <h1>게시글 보기</h1>

    <form method="POST">
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
                <td>작성자</td>
                <td>${post.getUsername()}</td>
            </tr>
            <tr>
                <td>작성시간</td>
                <td>${post.getCreatedTime()}</td>
            </tr>
        </table>

        <a class="btn btn-primary" href="http://localhost:8080/api/v1/post/${post.getId()}/return?check=2">수정</a>
        <a href="http://localhost:8080/api/v1/post/${post.getId()}/comment" class="btn btn-warning">댓글보기</a>
        <a href="http://localhost:8080/api/v1/post/${post.getId()}/comment/return" class="btn btn-warning">댓글쓰기</a>
        <a href="http://localhost:8080/post/delete?postId=${post.getId()}" class="btn btn-warning">게시글 삭제</a>
        <a href="javascript:window.history.back()" class="btn btn-info">뒤로가기</a>
        <a href="http://localhost:8080/api/v1/post" class="btn btn-info">처음으로</a>
    </form>
</div>
</body>
</html>