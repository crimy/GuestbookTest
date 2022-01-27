<%@ page contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<%@taglib prefix="q" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>

<style>
body {
    background-image: linear-gradient(#CAF0FA, #D6EBFF);
}

.list {
    background-color: #D1E9F6;
    width: 55%;
    text-align: center;
    margin: auto;
    border-radius: 20px;
    cellspacing: 0px;
    cellpadding: 8px;
}

td {
    border: 4px solid #BACFDE;
}

.add {
    position: absolute;
    left: 32%;
    bottom: 20%;
}

.input_con {
    width: 370px;
    height: 65px;
    border: 4px solid #BACFDE;
    border-radius: 15px;
}

.btn {
    width: 60px;
    height: 50px;
    background-color: #D1E9F6;
    border-radius: 40%;
    border: 4px solid #BACFDE;
}

.del {
    font-size: 10px;
    font-color: #BACFDE;
}
</style>
</head>
<body>

    <div class="bg">
        <table class="list">
            <tr>
                <th width="60px">번호</th>
                <th>내용</th>
            </tr>
            <q:forEach items="${list}" var="t">
                <tr>
                    <td>${t.no}</td>
                    <td>${t.content}<a class="del" href="del.gb?no=${t.no}">[삭제]</a>
                    </td>
                </tr>
            </q:forEach>
        </table>
    </div>
    <div class="bg">
        <form class="add" method="POST" action="add.gb">
            <input class="input_con" type="text" name="content"
                placeholder="내용 입력" /> <input type="password" name="password"
                maxlength="4" placeholder="비밀번호 4자리" /> <input class="btn"
                type="submit" />
        </form>
    </div>
</body>
</html>
