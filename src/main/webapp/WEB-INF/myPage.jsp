<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>

<!DOCTYPE html>
<html>
<style>
    body { font-family: 굴림체; }
    input.form-control, select.form-control { width: 200px; }
    h1 {
        margin-top: 50px;
    }
</style>
<body>

<div class="container">
    <h1>My Page</h1>
    <hr/>

    <div class="form-group">
        <label>사용자 닉네임</label>
        <label>
            <input type="text" class="form-control" name="loginId" value="${mypage.getUsername()}" readonly>
        </label>
    </div>
    <div class="form-group">
        <label>전체 게시글 수</label>
        <label>
            <input type="text" class="form-control" name="password" value="${mypage.getPostAllCount()}" readonly>
        </label>
    </div>
    <div class="form-group">
        <label>전체 조회 수</label>
        <label>
            <input type="text" class="form-control" name="name" value="${mypage.getPostViewsCount()}" readonly>
        </label>
    </div>

    <a href="javascript:window.history.back()" class="btn btn-info">게시글로</a>

</div>
</body>
</html>