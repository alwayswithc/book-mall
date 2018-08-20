package dao.dao;

import domain.Book;

public interface ProductDAO {
	
	Book findBookById(Integer id);  //根据编号查找出一本书

}
