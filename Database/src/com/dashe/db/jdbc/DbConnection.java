package com.dashe.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo1";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";

	public static void main(String[] args) throws Exception {
		// 注册驱动
		Class.forName(DBDRIVER);
		// 建立连接
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		// 创建STATMENT语句d的对象
		Statement st = conn.createStatement();

		String sql = "insert into test (id,name) values(18,'laowang') ;";
		// 执行插入数据的操作
		st.executeLargeUpdate(sql);
		
		System.out.println("运行结束");
		st.close();
		conn.close();

	}

}
