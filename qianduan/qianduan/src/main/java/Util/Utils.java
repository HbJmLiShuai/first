package Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    private static SqlSessionFactory factory=null;
    static
    {
        String config="mybatis.xml";
        try {
            InputStream in= Resources.getResourceAsStream(config);
            //创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            //创建SqlSessionFactory对象
             factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSession()
    {
        SqlSession sqlSession=null;
        if(factory!=null)
        {
            sqlSession= factory.openSession(true);
        }
        return sqlSession;

    }

}
