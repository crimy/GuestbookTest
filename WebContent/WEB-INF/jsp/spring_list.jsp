<%@ page contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<%@taglib prefix="q" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image: linear-gradient(#CAF0FA,#D6EBFF);
}
.pwd {
	width : 200px;
	height: 100px;
}
</style>

</head>
<body>
	<form class="pwd" method="POST" action="del.gb">
		<input type="password" name="password" maxlength="4" placeholder="��й�ȣ 4�ڸ�"/>
	</form>
</body>
</html>