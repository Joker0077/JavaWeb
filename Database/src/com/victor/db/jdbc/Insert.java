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
		// ע������
		Class.forName(DBDRIVER);
		// ��������
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		// ����preparedstatement���� ?��ռλ��
		String sql = "insert into user (id,name ,age) values(?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 2);
		ps.setString(2, "jinx");
		ps.setInt(3, 20);

		int i = ps.executeUpdate();
		
		
		System.out.println("i="+i);
		System.out.println("���н���");
		ps.close();
		conn.close();
	}

}
