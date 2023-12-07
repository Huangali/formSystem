package com.formSysytem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class FormSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormSystemApplication.class, args);
    }

}
