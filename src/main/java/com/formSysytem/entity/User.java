package com.formSysytem.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "login_user")
public class User implements Serializable {
    @Id
    private String _id;

    private String userName;

    private String password;
    @Transient
    private String newPassword;

}