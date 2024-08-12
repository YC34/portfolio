<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>HOME</title>
</head>
<body>
    <h1>WELCOME HOME</h1>
    <ul>
       <c:if test="${empty sessionScope.auth || empty sessionScope.username}">
        <li><a href="signUp">회원가입</a></li>
        <li><a href="login">로그인</a></li>
       </c:if>
       <c:if test="${not empty sessionScope.auth && not empty sessionScope.username}">
          <c:if test="${ sessionScope.auth[0] == 'ADMIN'}">
              <li><a href="">관리자 메뉴</a></li>
          </c:if>
          <c:if test="${sessionScope.auth[0] == 'USER'}">
              <li>${sessionScope.username}</li>
              <li><a href="">유저 메뉴</a></li>
          </c:if>
        <li><a href="logout"></a>로그아웃</li>
        <p>${sessionScope.auth}</p>
       </c:if>
    </ul>


</body>
</html>
