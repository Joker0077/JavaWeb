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
		// ע������
		Class.forName(DBDRIVER);
		// ��������
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		// ����STATMENT���d�Ķ���
		Statement st = conn.createStatement();

		String sql = "insert into test (id,name) values(18,'laowang') ;";
		// ִ�в������ݵĲ���
		st.executeLargeUpdate(sql);
		
		System.out.println("���н���");
		st.close();
		conn.close();

	}

}
