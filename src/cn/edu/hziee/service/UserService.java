package cn.edu.hziee.service;

import cn.edu.hziee.mapper.UserMapper;
import cn.edu.hziee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired

    private UserMapper userMapper;

    public int register(User user){
        return this.userMapper.insertUser(user);
    }

    public User findUserById(int uid){
        return this.userMapper.findUserById(uid);
    }

    public User findUserByIdName(String username){return this.userMapper.findUserByIdName(username);}

    public void updateUserBalanceByUid(User user){this.userMapper.updateUserBalanceByUid(user);}

}