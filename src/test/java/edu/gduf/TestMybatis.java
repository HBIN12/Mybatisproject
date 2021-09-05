package edu.gduf;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class TestMybatis {

    private SqlSessionFactory sessionFactory;
    @Before
    public void init() {
        InputStream is = null;
        /*读取文件抛出异常*/
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getSession(){
        SqlSession session=sessionFactory.openSession();
        System.out.println("session:"+session);
    }
/*
    @Test
    public void insertTest() {
        SqlSession session=sessionFactory.openSession();
        User user=new User("CB","123123","user");
        int result = session.insert("edu.gduf.mapper.UserMapper.insert", user);
        System.out.println("成功插入"+result+"条数据");
        session.commit();
        session.close();
    }*/

/*    @Test
    public void DeleteByNameTest() {
        SqlSession session=sessionFactory.openSession();
        String name="CB";
        int result = session.delete("edu.gduf.mapper.UserMapper.DeleteByName", name);
        System.out.println("成功删除了姓名为"+name+"的"+result+"条记录");
        session.commit();
        session.close();
    }*/

/*    @Test
    public void ResetPasswordByIdTest() {
        SqlSession session=sessionFactory.openSession();
        Integer id=10003;
        session.update("edu.gduf.mapper.UserMapper.ResetPasswordById", id);
        System.out.println("重置id："+id+"的密码为000000");
        session.commit();
        session.close();
    }*/

 /*   @Test
    public void SelectAllUser() {
        SqlSession session=sessionFactory.openSession();
        List<User> list = session.selectList("edu.gduf.mapper.UserMapper.SelectAllUser");
        for(User user:list){
            System.out.println("ID:"+user.getId()+",Name:"+user.getName()+",role:"+user.getRole());
        }
        session.close();
    }*/

/*    @Test
    public void SelectAllUser() {
        SqlSession session=sessionFactory.openSession();
        Map<Integer, User> UserMap = session.selectMap("edu.gduf.mapper.UserMapper.SelectAllUser", "id");
        Set<Integer> ids=UserMap.keySet();
        for(Integer id:ids){
            System.out.println("ID:"+UserMap.get(id).getId()+",Name:"+UserMap.get(id).getName()+",role:"+UserMap.get(id).getRole());
        }
        session.close();
    }*/
}
