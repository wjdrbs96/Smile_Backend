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
    <h1>댓글 수정</h1>
    <form action="/post/25/comment/${comment.getCommentId()}" method="POST">
        <input type="hidden" name="_method" value="PUT"/>
        <table class="table table-bordered table-condensed">
            <tr>
                <td class="mid">댓글</td>
                <td>
                    <label>
                        <textarea class="form-control" name="content" rows="4" required>${comment.getContent()}</textarea>
                    </label>
                </td>
            </tr>
        </table>
        <button type="submit" class="btn btn-primary">수정</button>
    </form>
</div>

</body>
</html>