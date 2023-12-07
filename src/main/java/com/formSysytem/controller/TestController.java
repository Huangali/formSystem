package com.formSysytem.controller;

import com.alibaba.fastjson.JSONObject;
import com.formSysytem.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author U
 * @className: TestController
 * @description: TODO
 * @date 2023/11/17 16:44
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private MongoService mongoService;

    @PutMapping("/update")
    public Object updateDocument(@RequestBody JSONObject jsonObject) {
        // 提取 JSON 对象中的字段
        String collectionName = jsonObject.getString("collectionName");
        String updatedField = jsonObject.getString("updatedField");
        Object value = jsonObject.get("value");
        // 更新文档
//        mongoTemplate.updateFirst(collectionName, updatedField, value);
        // 返回响应
        return "Document updated successfully";
    }
    @RequestMapping("/insert")
    public Object insertAndUpdate() {
//        mongoTemplate
        System.out.println(111);
//        mongoTemplate.insert(user);
//        mongoTemplate.in
        HashMap<String, Object> map = new HashMap<>();
        map.put("templateName", "test");
        map.put("createTime",new Date());
        map.put("updateTime",new Date());
//        mongoService.insert(map);
        return "Document inserted and updated successfully";
    }


}
