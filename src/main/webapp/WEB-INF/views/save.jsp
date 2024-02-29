<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
</head>
<body>
    <form action = "/member/save" method = "post">
        <label>
            <input type = "text" name = "memberEmail" placeholder = "이메일">
            <input type = "text" name = "memberPassword" placeholder = "비밀 번호">
            <input type = "text" name = "memberName" placeholder = "이름">
            <input type = "text" name = "memberAge" placeholder = "나이">
            <input type = "text" name = "memberMobile" placeholder = "전화 번호">
            <input type = "text" name = "memberEmail" placeholder = "이메일">
            <input type = "submit" value = "회원 가입">
        </label>
    </form>
</body>
</html>
