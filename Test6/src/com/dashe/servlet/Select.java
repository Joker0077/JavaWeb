package com.dashe.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dashe.bean.User;



/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param pageContext 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, ServletRequest pageContext) throws ServletException, IOException {
		ArrayList<User> list =new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			// 创建STATEMENT语句对象
			String sql = "select * from stu;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet st = stmt.executeQuery();
			while (st.next()) {
				User user= new User();
				user.setId(st.getString(1));
				user.setName(st.getString(2));
				user.setAge(st.getString(3));
				list.add(user);
				pageContext.setAttribute("list", list);
			}
			
			/*stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, age);*/
			/*stmt.executeUpdate();*/
			// 执行插入数据得操作
			System.out.println("执行结束");
			stmt.close();
			conn.close();
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
