package com.dashe.bean;



public interface UserDao {
	public void addUser(User user);		// 增加
	public void  updateUser( User user);
	public void deleteUser( int id);
	public  User getUserById(int id );
	
}
