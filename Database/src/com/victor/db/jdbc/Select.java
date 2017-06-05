package com.victor.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo1";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";

	public static void main(String[] args) throws Exception {
		// ע������
		Class.forName(DBDRIVER);
		// ��������
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		// ����preparedstatement����
		String sql = "select id ,name as username,age from user;";
		PreparedStatement ps = conn.prepareStatement(sql);

		// ����SQL���
		// ִ�м�����ݵĲ���
		ResultSet rs = ps.executeQuery(sql);
		// �����ѯ��������
		System.out.println("id" + "\t\t" + "name" + "\t\t" + "age" + "\t\t");

		while (rs.next()) {
			// ʹ���ֶε�����ȥȡ����1��ʼ
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);

			System.out.println(".........................................");
			System.out.print(id + "\t\t");
			System.out.print(name + "\t\t");
			System.out.print(+age + "\t\t");
			System.out.println();

		}
		System.out.println("���н���");
		rs.close();
		conn.close();

	}

}
