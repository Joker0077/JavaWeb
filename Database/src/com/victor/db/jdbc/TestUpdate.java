package com.victor.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestUpdate {

	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo1";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";

	public static void main(String[] args) throws Exception {
		Class.forName(DBDRIVER);
		// 建立连接
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		Statement st = conn.createStatement();
		String sql = "select * from user;";
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			System.out.println(".........................................");
			System.out.print(id + "\t\t");
			System.out.print(name + "\t\t");
			System.out.print(+ age + "\t\t");
			System.out.println();

		}
		System.out.println("运行结束");
		rs.close();
		st.close();
		conn.close();

	}
}
