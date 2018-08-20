package dao.daoImpl;

import dao.dao.UserDAO;
import domain.Book;
import domain.User;
import handler.BeanHandler;
import util.JdbcTemplate;

public class UserDAOImpl implements UserDAO{

	public void addUser(User user) {
		JdbcTemplate.update("INSERT INTO user(username,password,email,telephone,activeCode) VALUES(?,?,?,?,?)", user.getUsername(),user.getPassword(),user.getEmail(),user.getTelephone(),user.getActiveCode());
		
	}

	public User findUser(String username, String password) {
		return JdbcTemplate.query("select * from user where username=? and password=?",new BeanHandler<>(User.class),username, password);
	}
 
}
