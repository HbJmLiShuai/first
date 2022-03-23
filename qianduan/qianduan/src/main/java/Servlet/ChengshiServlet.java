package Servlet;

import Dao.Chengshi;
import JavaBean.Page;
import Util.GetPage;
import Util.Utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/ok/*")
public class ChengshiServlet extends BaseServlet{
    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = Utils.getSession();
        Chengshi mapper = sqlSession.getMapper(Chengshi.class);
        List<Chengshi> select = mapper.select();
        String s = JSON.toJSONString(select);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(s);
        sqlSession.close();
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        JavaBean.Chengshi chengshi = JSON.parseObject(s, JavaBean.Chengshi.class);
        SqlSession sqlSession1 = Utils.getSession();
        Chengshi mapper = sqlSession1.getMapper(Chengshi.class);
        try {
            mapper.add(chengshi);
            resp.getWriter().println("添加成功");
        }
        catch (Exception e)
        { resp.getWriter().println("输入有误");}


        sqlSession1.close();


    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        SqlSession sqlSession = Utils.getSession();
        Chengshi mapper = sqlSession.getMapper(Chengshi.class);
        mapper.delete(i);
        resp.getWriter().println("删除成功");
        sqlSession.close();

    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        SqlSession sqlsession = Utils.getSession();
        Chengshi mapper = sqlsession.getMapper(Chengshi.class);
        JavaBean.Chengshi chengshi = JSON.parseObject(s, JavaBean.Chengshi.class);
        try {
            mapper.update(chengshi);
            resp.getWriter().println("更新成功");
        }catch (Exception e)
        {
            resp.getWriter().println("更新失败");
        }
        sqlsession.close();

    }
    public void selectBypage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String currentPage1 = req.getParameter("currentPage");
        String pageSize1 = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(currentPage1);
        int pageSize = Integer.parseInt(pageSize1);
        Page<JavaBean.Chengshi> getpage = GetPage.getpage(currentPage,pageSize);
        String s = JSON.toJSONString(getpage);
        resp.getWriter().println(s);


    }
    public void chaxun(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String currentPage1 = req.getParameter("currentPage");
        String pageSize1 = req.getParameter("pageSize");
        BufferedReader reader = req.getReader();
        String s1 = reader.readLine();
        JavaBean.Chengshi chengshi = JSON.parseObject(s1, JavaBean.Chengshi.class);
        int currentPage = Integer.parseInt(currentPage1);
        int pageSize = Integer.parseInt(pageSize1);
        Page<JavaBean.Chengshi> page = GetPage.getpage1(currentPage,pageSize,chengshi);
        String s = JSON.toJSONString(page);
        resp.getWriter().println(s);
    }


}

