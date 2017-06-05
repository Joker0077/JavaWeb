package com.victor.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Insert {

	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo1";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";

	public static void main(String[] args) throws Exception {
		// 注册驱动
		Class.forName(DBDRIVER);
		// 建立连接
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		// 创建preparedstatement对象 ?是占位符
		String sql = "insert into user (id,name ,age) values(?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 2);
		ps.setString(2, "jinx");
		ps.setInt(3, 20);

		int i = ps.executeUpdate();
		
		
		System.out.println("i="+i);
		System.out.println("运行结束");
		ps.close();
		conn.close();
	}

}
