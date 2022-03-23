package Servlet;

import Dao.DengluDao;
import JavaBean.Denglu;
import Util.Utils;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/yanzheng")
public class YanZhen extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Denglu denglu = new Denglu();
        denglu.setUsername(username);
        denglu.setPassword(password);
        SqlSession sqlSession = Utils.getSession();
        DengluDao mapper = sqlSession.getMapper(DengluDao.class);
        List<Denglu> select = mapper.select(denglu);
        if(select.size()!=0)
        {
            HttpSession session = req.getSession();
            session.setAttribute("denglu",select);
            resp.sendRedirect(req.getContextPath()+"/guanli.html");
        }
        else
        {
            writer.println("<script type='text/javascript'>");
            writer.println("window.alert('账号或密码错误')");
            writer.println("location.href='"+req.getContextPath()+"/denglu.html'");
            writer.println("</script>");
        }
    }
}
