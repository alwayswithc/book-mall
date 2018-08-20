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
		
		//做请求分发处理
		String cmd=req.getParameter("cmd");
		if(cmd.equals("register")) {
			this.register(req, resp);
		}else if(cmd.equals("login")){
			this.login(req, resp);
	    }else if(cmd.equals("check")) {
			this.check(req, resp);
		}else if(cmd.equals("logout")) {
			this.logout(req, resp);
		}else if(cmd.equals("login2")) {   //用于首页弹窗的登陆
			this.login2(req, resp);
		}
	}
	//将请求中的信息封装成User对象
	private void reqToUser(HttpServletRequest req,User user) {

			//获取填入的用户信息
			String username=req.getParameter("uname");
			String password=req.getParameter("password");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setTelephone(phone);
			user.setActiveCode(UUID.randomUUID().toString());//手动设置激活码
				
	}
	
	//注册
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=new User();
		this.reqToUser(req, user);
		u.addUser(user);
		req.getSession().setAttribute("user", user);//把用户信息封装到session对象中
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	//注册时的检验码检查
	private void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		String code=req.getParameter("code");
		String c=(String) req.getSession().getAttribute("verifyCode");
		if(c.equals(code)) {
			out.print("{\"flag\":\"true\",\"msg\":\"<font style='color:green'>验证码正确</font>\"}");
		}else {
			out.print("{\"flag\":\"false\",\"msg\":\"<font style='color:red'>验证码错误</font>\"}");
		}
	}
	
	//登陆
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username=req.getParameter("logname");
		String password=req.getParameter("logpass");
		//根据用户名和密码找到用户
		User user=u.findUser(username, password);
		if(user!=null) {
			String autologin=req.getParameter("autologin");
			Cookie cookie=new Cookie("user",user.getUsername()+"&"+user.getPassword());
			cookie.setPath("/");//cookie.setPath("/");之后，可以在webapp文件夹下的所有应用共享cookie
			if(autologin!=null) {
				cookie.setMaxAge(60*60*24*7);
			}else {
				cookie.setMaxAge(0);
			}
			resp.addCookie(cookie);  //把cookie对象保存到客户端
			req.getSession().setAttribute("user", user);
			System.out.println("登录成功");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	//注销用户
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
		//根据用户名和密码找到用户
		User user=u.findUser(username, password);
		req.getSession().setAttribute("user", user);
		System.out.println("登录成功");
		System.out.println(req.getSession().getAttribute("user"));
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
