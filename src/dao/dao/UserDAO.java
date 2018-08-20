package dao.dao;

import domain.Book;
import domain.User;

public interface UserDAO {
	
	void addUser(User user);  //添加用户：注册
	
	User findUser(String username,String password); //根据用户名和密码查找用户


	
	
}
