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
		//����id�ҵ���Ӧ����Ķ���
		Book b=pd.findBookById(Integer.valueOf(id));
		//�����Ʒ����Ϊ0����ɾ������
		if(num==0) {
			cart.clear();
		}else {
			cart.clear();
			//���ù��ﳵ�еĶ���������
			cart.put(b, num);
		} 
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}
	private void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
	    ProductDAO pd=new ProductDAOImpl();
		Book b=pd.findBookById(Integer.valueOf(id));
		HttpSession session=req.getSession();
		//��session�л�ȡ���ﳵ����
		Map<Book,Integer> cart=(Map<Book,Integer>)session.getAttribute("cart");
		//������ﳵΪ�գ�˵��û����Ʒ�洢�ڹ��ﳵ�У����������ﳵ
		if(cart==null) {
			cart=new HashMap<Book,Integer>() ;	
		}
		//���ﳵ�����Ʒ������Ϣ
		Integer count=cart.put(b, 1);
		//�����Ʒ������Ϊ�գ�����Ʒ����+1����������µ���Ʒ��Ϣssss
		if(count!=null) {
			cart.put(b, count+1);
		}  
		session.setAttribute("cart", cart);
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

}
