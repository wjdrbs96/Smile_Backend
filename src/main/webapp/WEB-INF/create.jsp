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
        margin-bottom: 10px;
    }
</style>
<body>

<div class="container">

    <h1>게시글 등록</h1>

    <form action="/post" method="post" enctype="multipart/form-data">
        <table class="table table-bordered table-condensed">
            <tr>
                <td>글 제목</td>
                <td>
                    <label>
                        <textarea class="form-control" name="title" rows="1" required></textarea>
                    </label>
                </td>
            </tr>
            <tr>
                <td>글 내용</td>
                <td>
                    <label>
                        <textarea class="form-control" name="content" rows="10" required></textarea>
                    </label>
                </td>
            </tr>
            <tr>
                <td>카테고리</td>
                <td>
                    <div id="margin" class="form-group">
                        <label>
                            <select name="category" class="form-control">
                                <option value="BOOK">독서</option>
                                <option value="LIFE">일상</option>
                                <option value="STUDY">공부</option>
                                <option value="TRAVEL">여행</option>
                            </select>
                        </label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>파일 업로드</td>
                <td>
                    <input multiple="multiple" name="image" type="file">
                </td>
            </tr>
        </table>

        <button type="submit" class="btn btn-primary">등록</button>
        <a href="javascript:window.history.back()" class="btn btn-info">돌아가기</a>
    </form>
</div>
</body>
</html>