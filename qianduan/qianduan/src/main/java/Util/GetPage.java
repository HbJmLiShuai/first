package Util;

import JavaBean.Chengshi;
import JavaBean.Page;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GetPage {
    public static Page<Chengshi> getpage(int currentPage,int pagesize)
    {
        int begin=(currentPage-1)*pagesize;
        int size=pagesize;
        SqlSession sqlSession = Utils.getSession();
        Dao.Chengshi mapper = sqlSession.getMapper(Dao.Chengshi.class);
        List<Chengshi> chengshis = mapper.selectBypage(begin, size);
        int count = mapper.selectTotalCount();
        Page<Chengshi> page=new Page<>();
        page.setRow(chengshis);
        page.setTotalCount(count);
        sqlSession.close();
        return page;

    }
    public static Page<Chengshi> getpage1(int currentPage,int pagesize,Chengshi chengshi)
    {
        int begin=(currentPage-1)*pagesize;
        int size=pagesize;
        String name = chengshi.getName();
        if(name.length()>0&&name!=null)
        {chengshi.setName("%"+name+"%");}
        SqlSession sqlSession = Utils.getSession();
        Dao.Chengshi mapper = sqlSession.getMapper(Dao.Chengshi.class);
        List<Chengshi> chengshis = mapper.chaxun(begin,size,chengshi);
        int count = mapper.countchaxun(chengshi);
        Page<Chengshi> page=new Page<>();
        page.setRow(chengshis);
        page.setTotalCount(count);
        sqlSession.close();
        return page;
    }
}
