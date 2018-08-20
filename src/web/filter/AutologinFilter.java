package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.dao.UserDAO;
import dao.daoImpl.UserDAOImpl;
import domain.User;



/**
 * Servlet Filter implementation class AutologinFilter
 */
@WebFilter(filterName="AutologinFilter",urlPatterns="/*")
public class AutologinFilter implements Filter {

    public AutologinFilter() {
    }
    public void init(FilterConfig fConfig) throws ServletException {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
	    HttpServletResponse resp=(HttpServletResponse) response;
	    String uri=req.getRequestURI();//autoLogin/login.jsp
	    String path=req.getContextPath();//autoLogin
	    path=uri.substring(path.length());// /login.jsp
	    //如果请求的资源不是login.jsp,也不是/servlet/loginServlet,才往下执行
	    if(!("/login.jsp".equals(path)||"/login".equals(path))) {
	    	User user=(User) req.getSession().getAttribute("user");
	    	//如果session得到了user对象，说明已经登陆过或者自动登录过
	    	//那么请求下一个资源时就不用执行自动登录了
	    	//用户没登录过，我们才执行自动登录
	    	if(user==null) {
	    		Cookie[] cookies=req.getCookies();
	    		String username="";
	    		String password="";
	    		for(int i=0;cookies!=null&&i<cookies.length;i++) {
	    			if("user".equals(cookies[i].getName())) {
	    				String value=cookies[i].getValue();
	    				String[] values=value.split("&");
	    				username=values[0];
	    				password=values[1];
	    			}
	    		}
	    		//登录操作
	    		UserDAO ud=new UserDAOImpl();
	    		User u=ud.findUser(username, password);
	    		//如果登录成功，把用户信息存到session中
	    		if(u!=null) {
	    			req.getSession().setAttribute("user", u);
	    		}
	    		
	    	}
	    }
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
