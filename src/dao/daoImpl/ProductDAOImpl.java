package dao.daoImpl;

import dao.dao.ProductDAO;
import domain.Book;
import handler.BeanHandler;
import util.JdbcTemplate;

public class ProductDAOImpl implements ProductDAO{

	@Override
	public Book findBookById(Integer id) {
		 return JdbcTemplate.query("select * from products where id=?", new BeanHandler<>(Book.class),id);
	}

}
