package edu.gduf;


import com.github.pagehelper.PageHelper;
import edu.gduf.bean.UserLevel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import edu.gduf.bean.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TestMybatis {

    private SqlSessionFactory sessionFactory;
    @Before
    public void init() {
        InputStream is;
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
    @Test
    public void insertTest() {
        SqlSession session=sessionFactory.openSession();
        User user=new User("CYB","123123","user");
        int result = session.insert("edu.gduf.mapper.UserMapper.insert", user);
        System.out.println("成功插入"+result+"条数据");
        System.out.println("最后插入的id："+user.getId());
        session.commit();
        session.close();
    }

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

    @Test
    public void SelectAllUser() {
        SqlSession session=sessionFactory.openSession();
        PageHelper.startPage(1,2);
        Map<Integer, User> UserMap = session.selectMap("edu.gduf.mapper.UserMapper.SelectAllUser", "id");
        Set<Integer> ids=UserMap.keySet();
        for(Integer id:ids){
            System.out.println("ID:"+UserMap.get(id).getId()+",Name:"+UserMap.get(id).getName()+",role:"+UserMap.get(id).getRole());
        }
        session.close();
    }

    @Test
    public void selectByids() {
        SqlSession session=sessionFactory.openSession();
        List<User> users = session.selectList("edu.gduf.mapper.UserMapper.selectByIds", new int[]{10001, 10003});
        users.stream().forEach(System.out::println);
    }

    @Test
    public void getUserById() {
        SqlSession session=sessionFactory.openSession();
        UserLevel userLevel = session.selectOne("edu.gduf.mapper.UserLevelMapper.getUserById", 10001);
        System.out.println("id:"+userLevel.getUser().getId()+",name:"+userLevel.getUser().getName()+",level:"+userLevel.getLevel());
        session.close();
    }

    @Test
    public void getAllUser() {
        SqlSession session=sessionFactory.openSession();
        List<UserLevel> userLevels = session.selectList("edu.gduf.mapper.UserLevelMapper.getAllUser");
        for (UserLevel userLevel :userLevels){
            System.out.println("id:"+userLevel.getUser().getId()+",name:"+userLevel.getUser().getName()+",level:"+userLevel.getLevel());
        }
        session.close();

    }
/*    @Test
    public void selectAllUser() {
        SqlSession session=sessionFactory.openSession();
        List<User> users = session.selectList("edu.gduf.mapper.UserMapper.selectAllUser");
        users.stream().forEach(System.out::println);
    }*/
}
