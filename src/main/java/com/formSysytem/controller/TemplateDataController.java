package com.formSysytem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formSysytem.service.MongoService;
import com.formSysytem.service.TemplateDataService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author U
 * @className: TemplateDataController
 * @description: TODO
 * @date 2023/11/19 17:40
 */
@RestController
@RequestMapping("/templateData")
public class TemplateDataController {
    @Autowired
    private TemplateDataService templateDataService;
    @Autowired
    private MongoService mongoService;

    @RequestMapping("/list")
    public Map<String,Object> list(@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "limit",required = false) Integer limit, @RequestParam(value = "templateName",required = false) String templateName){
        Map<String,Object> map = new HashMap<>();
        Map<String, Object> allList = templateDataService.findAllList(templateName, page, limit);
        Integer count = (Integer) allList.get("total");
//        List<Documented> content = (List<Documented>) allList.get("content");
        List<Document> data = (List<Document>) allList.get("data");

        map.put("code",0);
        map.put("success",true);
        map.put("msg","查询成功");
        map.put("count",count);
        map.put("data",data);
        return map;
    }

    /**
     * 根据id查询模板
     * @param _id
     * @return
     */
    @RequestMapping("/getTemplateById")
    public Map<String,Object> getTemplate(String _id){
        Map<String,Object> map = new HashMap<>();
        List<Document> template = mongoService.getTemplateById(_id);
        map.put("code",0);
        map.put("success",true);
        map.put("data",template);
        return map;
    }
    @RequestMapping("/saveTemplateData")
    public Map<String,Object> saveTemplateData(@RequestParam(value = "id", required = false)String _id,@RequestParam(value = "TemplateData",required = false)String data,@RequestParam(value = "dataId", required = false)String dataId) throws JsonProcessingException {
        Map<String,Object> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> dataList = objectMapper.readValue(data,Map.class);

        boolean b = templateDataService.saveTemplateData(_id, dataList, dataId);
        if(b){
            map.put("code",0);
            map.put("success",true);
            map.put("msg","保存成功");
        }else{
            map.put("code",1);
            map.put("success",false);
            map.put("msg","保存失败");
        }
        return map;
    }

    @RequestMapping("/delete")
    public Map<String,Object> delete(@RequestParam(value = "id",required = false)String id,@RequestParam(value = "dataId") String dataId){
        Map<String,Object> map = new HashMap<>();
        boolean b = templateDataService.delete(id,dataId);
        if(b){
            map.put("code",0);
            map.put("success",true);
            map.put("msg","删除成功");
        }else{
            map.put("code",1);
            map.put("success",false);
        }
        return  map;
    }
    @RequestMapping("/getTemplateDataById")
    public Map<String,Object> getTemplateDataById(@RequestParam(value = "id",required = false)String id,@RequestParam(value = "dataId",required = false) String dataId){
        Map<String,Object> map = new HashMap<>();
        List<Document> template = templateDataService.getDataById(id,dataId);
        if (template != null){
            map.put("code",0);
            map.put("success",true);
            map.put("data",template);
        }else {
            map.put("code",0);
            map.put("success",false);
            map.put("data",template);
        }
        return map;
    }
}
