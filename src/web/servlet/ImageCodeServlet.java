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
        // ����http��Ӧ���ļ�MIME����ΪͼƬ
        res.setContentType("image/jpeg");
        // �����������¼��ͼƬ�Ļ���
        res.setDateHeader("expries", -1);
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Pragma", "no-cache");
        // ���������һ��������VerifyCodeUtils������ָ��λ��(Ҳ��ָ������)����֤���ַ���
        String verifyCode = util.VerifyCodeUtils.generateVerifyCode(5);
        // ��������֤���ַ������浽session����,������б���֤
        req.getSession().setAttribute("verifyCode", verifyCode);
        // ����ͼƬ��д����Ӧ�������. ��Ϊregister.jspҳ�������֤��ͼƬ��߷ֱ�Ϊ180,30.����ʹ����һ��
        util.VerifyCodeUtils.outputImage(180, 30, res.getOutputStream(), verifyCode);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}