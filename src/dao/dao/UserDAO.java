package dao.dao;

import domain.Book;
import domain.User;

public interface UserDAO {
	
	void addUser(User user);  //����û���ע��
	
	User findUser(String username,String password); //�����û�������������û�


	
	
}
