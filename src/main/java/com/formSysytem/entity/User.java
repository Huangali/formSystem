package com.formSysytem.entity;


import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author U
 * @className: User
 * @description: TODO
 * @date 2023/11/17 17:00
 */

public class User {
    private String id;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
