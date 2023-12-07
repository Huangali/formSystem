package com.formSysytem.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author U
 * @className: Template
 * @description: TODO
 * @date 2023/11/19 22:57
 */
@Data
@Document(collection = "template")
public class Template {
    @Id
    private String _id;
    private String templateName;
    private Date createTime;
    private Date updateTime;

    private int delete;
}
