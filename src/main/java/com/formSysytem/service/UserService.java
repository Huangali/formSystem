package com.formSysytem.service;


import com.formSysytem.entity.User;

public interface UserService {
    User login(User id);
    int update(User record);
    int insert(User record);

    User getByName(String username);
}
