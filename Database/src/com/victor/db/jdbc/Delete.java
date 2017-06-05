package com.victor.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo1";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";

	public static void main(String[] args) throws Exception {
		Class.forName(DBDRIVER);

		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		Statement st = conn.createStatement();
		String sql = "delete from user where id=2;";
		// String sql1 = "update user set age=66 where id=5;";
		int i = st.executeUpdate(sql);

		System.out.println("i=" + i);

		System.out.println("‘À––Ω· ¯");
		st.close();
		conn.close();

	}

}
