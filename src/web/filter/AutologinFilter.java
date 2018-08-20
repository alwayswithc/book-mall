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
	    //����������Դ����login.jsp,Ҳ����/servlet/loginServlet,������ִ��
	    if(!("/login.jsp".equals(path)||"/login".equals(path))) {
	    	User user=(User) req.getSession().getAttribute("user");
	    	//���session�õ���user����˵���Ѿ���½�������Զ���¼��
	    	//��ô������һ����Դʱ�Ͳ���ִ���Զ���¼��
	    	//�û�û��¼�������ǲ�ִ���Զ���¼
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
	    		//��¼����
	    		UserDAO ud=new UserDAOImpl();
	    		User u=ud.findUser(username, password);
	    		//�����¼�ɹ������û���Ϣ�浽session��
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
