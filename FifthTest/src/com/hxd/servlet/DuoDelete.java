package com.hxd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxd.dao.UserDao;
import com.hxd.factory.UserDaoFactory;

import javafx.beans.binding.StringBinding;
import lombok.val;

/**
 * Servlet implementation class DuoDelete
 */
@WebServlet("/servlet/DuoDelete")
public class DuoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuoDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("duo");
		if ("删除所有勾选".equals(value)) {
			String[] ids = request.getParameterValues("gou");
			for (String id1 : ids) {
				int id=Integer.parseInt(id1);
				UserDao userDao=UserDaoFactory.getUserDAOInstance();
				userDao.deleteUser(id);
			}
			response.sendRedirect("../index.jsp");		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
