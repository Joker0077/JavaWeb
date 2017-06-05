package com.dashe.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo1";
	public static final String DBUSER = "root";
	public static final String DBPWD = "root";
	public static void main(String[] args) throws Exception {
		Class.forName(DBDRIVER);
		// 建立连接
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
	 Statement st=conn.createStatement();
	 String sql ="select * from user;";
	 ResultSet rs = st.executeQuery(sql);
	 

	 while(rs.next()){
	 int id = rs.getInt("id");
	 String name = rs.getString("name");
	 int age = rs.getInt("age");
	  
		 System.out.println("id="+id+"\t\t");
		 System.out.println("name="+name+"\t\t");
		 System.out.println("age="+age+"\t\t");
		 System.out.println();
		
	 }
	 System.out.println("hello");
	 st.close();
		conn.close();
	
	
	
	}

}
