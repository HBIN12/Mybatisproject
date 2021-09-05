package edu.gduf.mapper;
import edu.gduf.bean.User;

public interface UserMapper {
    void insert(User user);
    void DeleteByName(String name);
    void ResetPasswordById(Integer id);
    User SelectAllUser();
}
