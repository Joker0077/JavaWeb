package com.dashe.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id =request.getParameter("id");
			String name =request.getParameter("name");
			String age =request.getParameter("age");
		// 注册驱动
				try {
					Class.forName("com.mysql.jdbc.Driver");
					// 建立连接
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
					// 创建STATEMENT语句对象
					String sql = "insert into stu  values(?,?,?);";
					  PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, id);
					stmt.setString(2, name);
					stmt.setString(3, age);
					stmt.executeUpdate();
					// 执行插入数据得操作
					System.out.println("执行结束");
					stmt.close();
					conn.close();
					request.getRequestDispatcher("/Index.jsp").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
