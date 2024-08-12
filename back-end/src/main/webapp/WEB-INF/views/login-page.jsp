<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 8/8/24
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login-page</title>
</head>
<body>
    <h1>hello login page</h1>
    <form method="post" action="/loginProc" >
        <div>
            <label for="email">이메일:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">로그인</button>
        </div>
    </form>
</body>
</html>
