<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>添加用户</title>
	</head>
	<body>
		<form action="insertuser" method="post">
			编号: <input type="text" name="uid" /><br/><br/>
			用户名: <input type="text" name="uname" /><br/><br/>
			密码: <input type="text" name="password" /><br/><br/>
			性别: <input type="text" name="sex" /><br/><br/>
			电话: <input type="text" name="phone" /><br/><br/>
			地址: <input type="text" name="address" /><br/><br/>
			<input type="submit" value="确定" />
		</form>
	</body>
</html>








