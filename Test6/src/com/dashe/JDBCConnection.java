package com.dashe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws Exception {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 建立连接
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		// 创建STATEMENT语句对象
		  Statement stmt = conn.createStatement();

		String sql = "insert into stu (num,name,point) values( null ,'null',null);";

		stmt.executeUpdate(sql);
		// 执行插入数据得操作
		System.out.println("执行结束");
		stmt.close();
		conn.close();

	}
	
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

	
	
}
