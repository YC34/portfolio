<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imdong-gyu
  Date: 24. 8. 8.
  Time: 오후 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>

</head>
<body>
<div id="head">
	<h2>게시글 목록</h2>
		<hr />
		<ul class="list-group">
			<c:forEach var="board" items="${board}" varStatus="status">
				<li class="list-group-item  list-group-item-action d-flex justify-content-between align-items-center">
				    <a href="/${board.fNum}" class="text-decoration-none">
				    	[${board.count}] ${board.title}, ${board.date}
				    </a>
				    <a href="/board/delete/${board.fNum}"><span class="badge bg-secondary">&times;</span></a>
				</li>
				<hr/>
			</c:forEach>
		</ul>
		<hr />
	</div>
		<button id="add" type="button" class="btn btn-outline-info mb-3" data-bs-toggle="collapse"
		data-bs-target="#addForm" aria-expanded="false" aria-controls="addForm">게시글 작성</button>

		<div class="collapse" id="addForm">
			<div class="card card-body">
				<form method="post" action="/add" enctype="multipart/form-data">
					<label for="title" class="form-label">제목</label>
  					<input type="text" class="form-control" id="title" name="title" />
					<label for="content" class="form-label">내용</label>
  					<textarea class="form-control" name="content" id="content" cols="50" rows="5" ></textarea>
  					<button type="submit" class="btn btn-success mt-3">저장</button>
				</form>
			</div>
		</div>
</body>
</html>
