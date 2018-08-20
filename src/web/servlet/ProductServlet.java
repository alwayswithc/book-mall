package web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao.ProductDAO;
import dao.daoImpl.ProductDAOImpl;
import domain.Book;

@WebServlet("/Product")

public class ProductServlet extends HttpServlet{
	private ProductDAO p;
	public void init() throws ServletException {
		p=new ProductDAOImpl();
	}

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd=req.getParameter("cmd");
		if(cmd.equals("getBook")) {
			this.getBook(req, resp);
		}else if(cmd.equals("changeNum")) {
			this.changeNum(req,resp);
		}else if(cmd.equals("addCart")) {
			this.addCart(req, resp);
		}
		
	}
	private void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		String id=req.getParameter("id");
		Book b=p.findBookById(Integer.valueOf(id));
		req.setAttribute("b", b);
		req.getRequestDispatcher("/product.jsp").forward(req, resp);
	}
	
	private void changeNum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int num = Integer.parseInt(req.getParameter("num"));
		HttpSession session = req.getSession();
		Map<Book, Integer> cart = (Map<Book, Integer>) session.getAttribute("cart");
		ProductDAO pd=new ProductDAOImpl();
		//根据id找到对应的书的对象
		Book b=pd.findBookById(Integer.valueOf(id));
		//如果商品数据为0，就删除对象
		if(num==0) {
			cart.clear();
		}else {
			cart.clear();
			//重置购物车中的对象及其数量
			cart.put(b, num);
		} 
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}
	private void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
	    ProductDAO pd=new ProductDAOImpl();
		Book b=pd.findBookById(Integer.valueOf(id));
		HttpSession session=req.getSession();
		//从session中获取购物车对象
		Map<Book,Integer> cart=(Map<Book,Integer>)session.getAttribute("cart");
		//如果购物车为空，说明没有商品存储在购物车中，创建除购物车
		if(cart==null) {
			cart=new HashMap<Book,Integer>() ;	
		}
		//向购物车添加商品数量信息
		Integer count=cart.put(b, 1);
		//如果商品数量不为空，则商品数量+1，否则添加新的商品信息ssss
		if(count!=null) {
			cart.put(b, count+1);
		}  
		session.setAttribute("cart", cart);
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

}
