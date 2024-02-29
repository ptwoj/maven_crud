<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<h2>${sessionScope.loginEmail} 님 환영합니다.</h2>
<button onclick="update()">내 정보 수정하기</button>
<button onclick="logout()">로그 아웃</button>

</body>
<script>
    const update = () => {
        location.href = "/member/update";
    }
    const logout = () => {
        location.href = "/member/logout";
    }
</script>
</html>