package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageCodeServlet")

/**
 * Servlet implementation class imageCode
 */
public class ImageCodeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");
        //res.setContentType("text/html;charset=utf-8");
        // 设置http响应的文件MIME类型为图片
        res.setContentType("image/jpeg");
        // 不让浏览器记录此图片的缓存
        res.setDateHeader("expries", -1);
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Pragma", "no-cache");
        // 这里调用了一个工具类VerifyCodeUtils来生成指定位数(也可指定内容)的验证码字符串
        String verifyCode = util.VerifyCodeUtils.generateVerifyCode(5);
        // 将生成验证码字符串保存到session域中,方面进行表单验证
        req.getSession().setAttribute("verifyCode", verifyCode);
        // 生成图片并写到响应输出流里. 因为register.jsp页面里的验证码图片宽高分别为180,30.这里使保持一致
        util.VerifyCodeUtils.outputImage(180, 30, res.getOutputStream(), verifyCode);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}