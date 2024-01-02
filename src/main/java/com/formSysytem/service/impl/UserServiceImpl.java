package com.formSysytem.service.impl;


import com.formSysytem.entity.User;
import com.formSysytem.repository.UserRepository;
import com.formSysytem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User login(User id) {
        //查询用户
        User byUsername = userRepository.findByUserName(id.getUserName());
        return byUsername;
    }

    @Override
    public int update(User record) {

        record.setPassword(record.getNewPassword());
        User save = userRepository.save(record);
        //更新用户信息
        return save != null ? 1 : 0;
    }

    @Override
    public int insert(User record) {
        User insert = userRepository.insert(record);
        //插入用户信息
        return insert!= null? 1 : 0;
    }

    @Override
    public User getByName(String username) {
        User byUsername = userRepository.findByUserName(username);
        //获取用户，通过用户名
        return byUsername;
    }

}
