<%@page import="com.byzx.web.vo.User"%>
<%@page import="java.util.List"%>
<%@page import="com.byzx.web.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>首页面</title>
		<style>
			table{margin: 30px auto; font-size: 20px;text-align: center;}
			td{width: 150px;height: 50px;}
			tr:first-child{background-color: yellow;}
			tr:nth-child(2){background-color: orange;}
			tr:nth-child(2n+3){background-color: skyblue;}
			button{font-size: 20px; margin: 20px 115px;}
		</style>
	</head>
	<body>
		<button onclick="location.href='insert.jsp';">添加用户</button>
		<!-- 展示所有用户的信息 -->
		<table border="1">
			<tr>
				<td colspan="7">用户信息表</td>
			</tr>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>电话</td>
				<td>地址</td>
				<td>操作</td>
			</tr>
			<%
				UserService us = new UserService();
				List<User> users = us.findAllUser();
				// 遍历集合，将users中的数据显示在table表中
				for(User user: users){
			%>
				<tr>
					<td><%=user.getUid() %></td>
					<td><%=user.getUname() %></td>
					<td><%=user.getPassword() %></td>
					<td><%=user.getSex() %></td>
					<td><%=user.getPhone() %></td>
					<td><%=user.getAddress() %></td>
					<td>
						<a href="update.jsp?uid=<%=user.getUid() %>">修改</a>
						<a href="deleteuser?uid=<%=user.getUid() %>">删除</a>
					</td>
				</tr>	
			<%	
				}
			%>
		</table>
	</body>
</html>








