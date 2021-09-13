package edu.gduf.mapper;
import edu.gduf.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    void insert(User user);
    void DeleteByName(String name);
    void ResetPasswordById(Integer id);
    Map<Integer,User> SelectAllUser();
    List<User> selectByIds(Integer []ids);
   /* @Select("select  * from t_user ")
    List<User> selectAllUser();*/
}
