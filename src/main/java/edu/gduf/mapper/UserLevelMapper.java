package edu.gduf.mapper;


import edu.gduf.bean.UserLevel;

import java.util.List;

public interface UserLevelMapper {
    UserLevel getUserById(Integer id);
    List<UserLevel> getAllUser();
}
