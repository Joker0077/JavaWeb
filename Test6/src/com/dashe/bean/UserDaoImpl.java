package com.dashe.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dashe.JDBCConnection;
import com.dashe.bean.User;

public class UserDaoImpl implements UserDao {
    //下面三行是固定格式
	ResultSet rs = null;
	PreparedStatement ps = null;
	User user = null;
	
	@Override
	public void addUser(User user) {
		Connection conn=JDBCConnection.getConnection();
		
		String sql = "insert into stu  values( ? ,?,?);";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getId());
			ps.setString(2,user.getName());
			ps.setString(3,user.getAge());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
