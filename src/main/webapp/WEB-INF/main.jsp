<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
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
    <title>Smail Backend Gyunny</title>
</head>
<style>
    #margin{
        margin-bottom : 20px
    }
    .navbar.sticky-top.navbar-expand-lg.navbar-light {
        margin : 0px;
        background-color: white;
    }
</style>
<body>

<div class="container">
    <!-- 메뉴바 -->
    <nav class="navbar sticky-top navbar-expand-lg navbar-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080">Home</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- ./ 메뉴바 -->
    <form method="post" class="form-inline">
        <div id="margin" class="form-group">
            <select name="select" class="form-control">
                <option value="title">제목</option>
                <option value="nickname">작성자</option>
            </select>
            <input type="text" size=20 class="form-control" name="search"  placeholder="검색">
            <button type="submit" class="btn btn-primary">조회</button>
        </div>
    </form>

    <table class="table table-hover table table-striped">
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
<%--            <th>조회수</th>--%>
            <th>수정시간</th>
            <th>작성시간</th>
        </tr>

        <c:forEach items="${post}" var="post">
            <tr>
                <th>${post.getId()}</th>
                <th>${post.getUsername()}</th>
                <th>
                    <a href="">${post.getTitle()}</a>
                </th>
<%--                <th>${post.getCount()}</th>--%>
                <th>${post.getCreatedTime()}</th>
                <th>${post.getLastModifiedTime()}</th>
            </tr>
        </c:forEach>
    </table>

<%--  why not  <a href="create.jsp" class="btn btn-default pull-right">글쓰기</a>--%>
    <a href="http://localhost:8080/api/v1/post/return" class="btn btn-default pull-right">글쓰기</a>

    <ul class="pagination">
        <c:forEach var="i" begin="1" end="${totalPage}" step="1">
            <li class=<c:if test='${i} == ${page} ? "active" : ""'/>>
                <a href='/post/list?page=${i}&pageSize=${pageSize}'>${i}</a>
            </li>
        </c:forEach>
    </ul>
</div>

</body>