package com.formSysytem.repository;

import com.formSysytem.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUserName(String userName);
}
