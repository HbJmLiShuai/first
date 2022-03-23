package Dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Chengshi {
    List<Chengshi> select();
    void add(JavaBean.Chengshi chengshi);
    void delete(int c);
    void update(JavaBean.Chengshi chengshi);
    int selectTotalCount();
    List<JavaBean.Chengshi> selectBypage(@Param("begin") int begin,@Param("size") int size);
    List<JavaBean.Chengshi> chaxun(@Param("begin") int begin, @Param("size") int size, @Param("chengshi") JavaBean.Chengshi chengshi);
    int countchaxun(JavaBean.Chengshi chengshi);
}
