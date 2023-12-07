package com.formSysytem.service.impl;

import com.formSysytem.entity.Template;
import com.formSysytem.service.TemplateDataService;
import com.formSysytem.service.TemplateService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

/**
 * @author U
 * @className: TemplateDataServiceImpl
 * @description: TODO
 * @date 2023/11/19 17:42
 */
@Service
public class TemplateDataServiceImpl implements TemplateDataService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private TemplateService templateService;
    @Override
    public Map<String, Object> findAllList(String templateName, Integer page, Integer limit) {
        List<Document> templateData = mongoTemplate.findAll(Document.class, templateName);
        if (templateData != null){
            templateData.forEach(document -> {
                Object id = document.get("_id");
                if (id!= null){
                    document.remove("_id");
                    document.put("_id",id.toString());
                }
            });
        }
        int total = templateName.length()/limit+1;
        List<Document> documenteds = null;
        if (page == 1){
            if (templateData.size()>limit){
                documenteds = templateData.subList(0, limit);
            }else {
                documenteds = templateData;
            }
        }else {
            if (templateData.size()>limit){
                documenteds = templateData.subList((page-1)*limit, page*limit);
            }else {
                documenteds = templateData.subList((page-1)*limit, templateData.size());
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("data",documenteds);
        return map;
    }

    @Override
    public boolean saveTemplateData(String _id, Map<String, Object> templateData, String templateDataId) {
        Template byId = templateService.findById(_id);

        if (templateDataId == null){

            List<Document> template = mongoTemplate.findAll(Document.class, byId.getTemplateName());
            mongoTemplate.insert(templateData, byId.getTemplateName());
            return true;
        }else {
            List<Document> template = mongoTemplate.findAll(Document.class, byId.getTemplateName());
            Document document = new Document();
            document.putAll(templateData);
            Update update = new Update();
            templateData.forEach(update::set);
            UpdateResult id = mongoTemplate.upsert(new Query().addCriteria(Criteria.where("_id").is(templateDataId)), update, byId.getTemplateName());
            if (id!= null){
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean delete(String id, String dataId) {
        //获取到表单模板名称
        Template byId = templateService.findById(id);
        if (byId!= null){
            DeleteResult id1 = mongoTemplate.remove(new Query(Criteria.where("_id").is(dataId)), byId.getTemplateName());
            if (id1 != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Document> getDataById(String id, String dataId) {
        Template byId = templateService.findById(id);
        List<Document> documents = null;
        if (byId != null){
            documents = mongoTemplate.find(new Query().addCriteria(Criteria.where("_id").is(dataId)), Document.class, byId.getTemplateName());
        }
        return documents;
    }
}
