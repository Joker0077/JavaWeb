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
		// 注册驱动
		Class.forName(DBDRIVER);
		// 建立连接
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
		// 创建preparedstatement对象
		String sql = "select id ,name as username,age from user;";
		PreparedStatement ps = conn.prepareStatement(sql);

		// 构建SQL语句
		// 执行检查数据的操作
		ResultSet rs = ps.executeQuery(sql);
		// 处理查询到的数据
		System.out.println("id" + "\t\t" + "name" + "\t\t" + "age" + "\t\t");

		while (rs.next()) {
			// 使用字段的索引去取，从1开始
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);

			System.out.println(".........................................");
			System.out.print(id + "\t\t");
			System.out.print(name + "\t\t");
			System.out.print(+age + "\t\t");
			System.out.println();

		}
		System.out.println("运行结束");
		rs.close();
		conn.close();

	}

}
