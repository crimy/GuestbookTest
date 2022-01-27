<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="q" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
    background-image: linear-gradient(#CAF0FA,#D6EBFF);
}
.pwd {
    position: absolute;
    left: 50%;
    bottom: 50%;
}
.btn {
    width: 60px;
    height: 50px;
    background-color: #D1E9F6;
    border-radius: 40%;
    border: 4px solid #BACFDE;
}

</style>

</head>
<body>
<div class="pwd">
    <form method="POST" action="del2.gb">
        비밀번호: <input type="password" name="password" maxlength="4" placeholder="비밀번호 4자리"/>
        <input type="hidden" name="no" value="${no}">
        <input class="btn" type="submit"/>
    </form>
    <form class="cancel" method="POST" action="list.gb">
        <input class="btn" type="submit" value="취소"/>
    </form>
</div>
</body>
</html>