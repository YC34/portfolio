<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 8/8/24
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form method="post" action="/signUp" >
    <div>
        <label for="username">사용자 이름:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="email">이메일:</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <label for="role">역할:</label>
        <input type="hidden" id="role" name="roles" value="USER">
    </div>
    <div>
        <button type="submit">회원가입</button>
    </div>
</form>
</body>
</html>
