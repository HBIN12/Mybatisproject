package edu.gduf.mapper;
import edu.gduf.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    void insert(User user);
    void DeleteByName(String name);
    void ResetPasswordById(Integer id);
    Map<Integer,User> SelectAllUser();
}
