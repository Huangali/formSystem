package com.formSysytem.controller;


import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formSysytem.entity.Template;
import com.formSysytem.service.MongoService;
import com.formSysytem.service.TemplateService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author U
 * @className: TemplateController
 * @description: TODO
 * @date 2023/11/19 15:14
 */
@RestController
@RequestMapping("/form")
public class TemplateController {
    @Autowired
    private MongoService mongoService;
    @Autowired
    private TemplateService templateService;

    /**
     * 模板分页管理
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    public Map<String, Object> findAll(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        Map<String, Object> map = new HashMap<>();
        Page<Template> allList = templateService.findAllList(page - 1, limit);
        List<Template> content = allList.getContent();
        long totalPages = allList.getTotalElements();
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("count", totalPages);
        map.put("data", content);
        return map ;
    }

    /**
     * 根据id查询模板
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Map<String, Object> findById(String id) {
        Map<String, Object> map = new HashMap<>();
        Template template = templateService.findById(id);
        System.out.println(template.getTemplateName());
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", template);
        map.put("success", true);
        return map;
    }

    /**
     * 新增模板字段
     *
     * @param jsonString
     * @return
     */
    @RequestMapping("/addTemplate")
    public Map<String, Object> addTemplate( @RequestParam(value = "jsonData", required = false)String jsonString, @RequestParam(value = "id", required = false) String id) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> dataList = objectMapper.readValue(jsonString, List.class);

       mongoService.insert(dataList,id);

        map.put("code", 0);
        map.put("msg", "保存成功");
        map.put("success", true);

        return map;
    }

    /**
     * 获取某个模板的表格字段
     * @param id
     * @return
     */
    @RequestMapping("/getTemplateJsonById")
    public Map<String, Object> getTemplateById(@RequestParam(value = "id", required = false) String id) {
        Map<String, Object> map = new HashMap<>();
        List<Document> template = mongoService.getTemplate(id);
        List<Map<String, Object>>  jsonData = null;
        for (Document document : template) {
           for (String key : document.keySet()) {
               if (key.equals("jsonData")) {
                   System.out.println(key + ":" + document.get(key));
                   jsonData = (List<Map<String, Object>>) document.get(key);
               }
           }
        }
        map.put("code", 0);
        map.put("jsonData", jsonData);
        map.put("success", true);
        return map;
    }

    /**
     * 修改或添加模板，在添加模板时，添加一个集合，修改模板时，修改一个集合名
     *
     * @param template
     * @param id
     * @return
     */
    @PostMapping("/saveTemplateName")
    public Map<String, Object> saveTemplateName(Template template, @RequestParam(value = "id", required = false) String id) {
        Map<String, Object> map = new HashMap<>();
        if (!"template".equals(template.getTemplateName())) {

            if (id != null) {
                template.set_id(id);
            }
            boolean b = templateService.updataTemplateName(template);
            if (b) {
                map.put("code", 0);
                map.put("msg", "查询成功");
                map.put("data", template);
                map.put("success", true);
            } else {
                map.put("code", 1);
                map.put("msg", "模板名重复");
                map.put("data", template);
                map.put("success", false);
            }
        }else {
            map.put("code", 1);
            map.put("msg", "模板名不能为template");
            map.put("success", false);
        }


        return map;
    }

    /**
     * 删除模板
     *
     * @param _id
     * @return
     */
    @RequestMapping("/deleteTemplate")
    public Map<String, Object> deleteTemplate(String _id) {
        Map<String, Object> map = new HashMap<>();
        boolean flag = mongoService.deleteTemplate(_id);
        map.put("code", 0);
        if (flag) {
            map.put("msg", "删除成功");
            map.put("success", true);
        } else {
            map.put("msg", "删除失败");
            map.put("success", false);
        }
        return map;
    }


}
