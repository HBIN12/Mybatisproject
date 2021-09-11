package com.mbg;

import com.mbg.bean.TUser;
import com.mbg.bean.TUserExample;
import com.mbg.mapper.TUserMapper;
import edu.gduf.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MbgTest {
    private SqlSessionFactory sessionFactory;
    @Before
    public void init(){

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sessionFactory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getSession(){
        SqlSession session=sessionFactory.openSession();
        System.out.println("session:"+session);
    }


    @Test
    public void selectByName(){
        SqlSession session=sessionFactory.openSession();
        TUserExample example=new TUserExample();
        example.createCriteria().andNameLike("%Y%");
        List<TUser> tUsers = session.selectList("com.mbg.mapper.TUserMapper.selectByExample", example);
        tUsers.forEach(System.out::println);
        session.close();

    }
    @Test
    public void insert(){
        SqlSession session=sessionFactory.openSession();
        TUserExample example=new TUserExample();
        TUser user1=new TUser();
        user1.setId(null);
        user1.setName("CHL");
        user1.setPassword("1234123");
        user1.setRole("user");
        System.out.println("成功插入"+session.insert("com.mbg.mapper.TUserMapper.insertSelective", user1)+"个数据");
        session.commit();
        session.close();
    }
    @Test
    public void countByname(){

        SqlSession session=sessionFactory.openSession();
        TUserExample example=new TUserExample();
        example.createCriteria().andNameEqualTo("CYB");
        Integer count = session.selectOne("com.mbg.mapper.TUserMapper.countByExample", example);
        System.out.println(count);
    }

    }

