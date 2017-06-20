<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加数据</title>
</head>
<body>
<center>
	<h2>请输入增加的数据</h2>
	</center>
	<center>
		<form action="<%=request.getContextPath()%>/AddUser" method="get">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="name" /></td>
				</tr>
				
				<tr>
					<td>年齡</td>
					<td><input type="text" name="age" /></td>
				</tr>
				
			</table>
			<input type="submit" /> <input type="reset" />
			
		</form>
	</center>
</body>
</html>