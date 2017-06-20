<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*,com.dashe.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
	<%
	ArrayList<User> list =new ArrayList<User>();
	Class.forName("com.mysql.jdbc.Driver");
	// 建立连接
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
	// 创建STATEMENT语句对象
	String sql = "select * from stu;";
	PreparedStatement stmt = conn.prepareStatement(sql);
	ResultSet st = stmt.executeQuery();
	while (st.next()) {
		User user= new User();
		user.setId(st.getString(1));
		user.setName(st.getString(2));
		user.setAge(st.getString(3));
		list.add(user);
		pageContext.setAttribute("list", list);}
	%>
	<a href="Add.jsp" class="one" >添加用戶</a>
	
	
		<table align="center" style="border-collapse: collapse" align="center"
			border="1">
			<h2>学生信息表</h2>
			<tr>

				<td width="150px;" border="40px">ID</td>
				<td width="150px;" border="40px">姓名</td>
				<td width="150px;" border="40px">年龄</td>
				<td width="150px;" border="40px">可操作项</td>

				<c:forEach var="user" items="${ list}">
					<tr>
						
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.age}</td>
						
					</tr>
			</c:forEach>
			
		</table>
		<input type="submit" /> <input type="reset" />
	

</body>
</html>