package cn.edu.hziee.mapper;

import cn.edu.hziee.model.User;

public interface UserMapper {

    public User findUserById(int id);
    public  int insertUser(User user);
    public User findUserByIdName(String username);
    public void updateUserBalanceByUid(User user);

}
