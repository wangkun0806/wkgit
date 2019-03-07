<%@page import="com.byzx.web.vo.User"%>
<%@page import="com.byzx.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>修改用户</title>
	</head>
	<body>
		<%
			String uidstr = request.getParameter("uid");
			if(null == uidstr){
				response.sendRedirect("index.jsp");
				return;
			}
			int uid = Integer.parseInt(uidstr);
			UserService us = new UserService();
			User user = us.findUserById(uid);
		%>
		<form action="updateuser" method="post">
			编号: <input type="text" name="uid" value="<%=user.getUid() %>" readonly /><br/><br/>
			用户名: <input type="text" name="uname" value="<%=user.getUname() %>" /><br/><br/>
			密码: <input type="text" name="password" value="<%=user.getPassword() %>" /><br/><br/>
			性别: <input type="text" name="sex" value="<%=user.getSex() %>" /><br/><br/>
			电话: <input type="text" name="phone" value="<%=user.getPhone() %>" /><br/><br/>
			地址: <input type="text" name="address" value="<%=user.getAddress() %>" /><br/><br/>
			<input type="submit" value="确定" />
		</form>
	</body>
</html>








