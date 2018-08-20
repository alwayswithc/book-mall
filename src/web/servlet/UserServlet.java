package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.dao.UserDAO;
import dao.daoImpl.UserDAOImpl;
import domain.User;
@WebServlet("/user")
public class UserServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	private UserDAO u;
	@Override
	public void init() {
		u=new UserDAOImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//������ַ�����
		String cmd=req.getParameter("cmd");
		if(cmd.equals("register")) {
			this.register(req, resp);
		}else if(cmd.equals("login")){
			this.login(req, resp);
	    }else if(cmd.equals("check")) {
			this.check(req, resp);
		}else if(cmd.equals("logout")) {
			this.logout(req, resp);
		}else if(cmd.equals("login2")) {   //������ҳ�����ĵ�½
			this.login2(req, resp);
		}
	}
	//�������е���Ϣ��װ��User����
	private void reqToUser(HttpServletRequest req,User user) {

			//��ȡ������û���Ϣ
			String username=req.getParameter("uname");
			String password=req.getParameter("password");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setTelephone(phone);
			user.setActiveCode(UUID.randomUUID().toString());//�ֶ����ü�����
				
	}
	
	//ע��
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=new User();
		this.reqToUser(req, user);
		u.addUser(user);
		req.getSession().setAttribute("user", user);//���û���Ϣ��װ��session������
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	//ע��ʱ�ļ�������
	private void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		String code=req.getParameter("code");
		String c=(String) req.getSession().getAttribute("verifyCode");
		if(c.equals(code)) {
			out.print("{\"flag\":\"true\",\"msg\":\"<font style='color:green'>��֤����ȷ</font>\"}");
		}else {
			out.print("{\"flag\":\"false\",\"msg\":\"<font style='color:red'>��֤�����</font>\"}");
		}
	}
	
	//��½
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username=req.getParameter("logname");
		String password=req.getParameter("logpass");
		//�����û����������ҵ��û�
		User user=u.findUser(username, password);
		if(user!=null) {
			String autologin=req.getParameter("autologin");
			Cookie cookie=new Cookie("user",user.getUsername()+"&"+user.getPassword());
			cookie.setPath("/");//cookie.setPath("/");֮�󣬿�����webapp�ļ����µ�����Ӧ�ù���cookie
			if(autologin!=null) {
				cookie.setMaxAge(60*60*24*7);
			}else {
				cookie.setMaxAge(0);
			}
			resp.addCookie(cookie);  //��cookie���󱣴浽�ͻ���
			req.getSession().setAttribute("user", user);
			System.out.println("��¼�ɹ�");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	//ע���û�
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getSession().removeAttribute("user");
		Cookie cookie=new Cookie("user"," ");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
	private void login2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username=req.getParameter("logname");
		String password=req.getParameter("logpass"); 
		//�����û����������ҵ��û�
		User user=u.findUser(username, password);
		req.getSession().setAttribute("user", user);
		System.out.println("��¼�ɹ�");
		System.out.println(req.getSession().getAttribute("user"));
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
