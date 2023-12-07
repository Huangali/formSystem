package com.formSysytem.service.impl;

import com.formSysytem.service.MongoService;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author U
 * @className: MongoService
 * @description: TODO
 * @date 2023/11/17 21:15
 */
@Service
public class MongoServiceImpl implements MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入模板字段
     * @param map
     * @param id
     * @return
     */
    @Override
    public int insert(List<Map<String, Object>> map, String id) {
//        Document document = new Document();
//        map.forEach(document::append);
//        mongoTemplate.insert(document,"template");
        HashMap<String, Object> s = new HashMap<>();
        s.put("_id", id);
        s.put("jsonData", map);
        s.put("updateTime", new Date());
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)),new Update().set("jsonData", map),"template");
        return 1;
    }

    /**
     * 获取模板
     * @param id
     * @return
     */
    @Override
    public List<Document> getTemplate(String id) {
        List<Document> documents = mongoTemplate.find(new Query(Criteria.where("_id").is(id)), Document.class, "template");
        return documents;
    }

    /**
     * 更新模板
     * @param obj
     * @return
     */
    @Override
    public boolean updateTemplate(Map<String, Object> obj) {
        if (mongoTemplate.exists(new Query(Criteria.where("_id").is(obj.get("_id"))), "template")) {
          mongoTemplate.upsert(new Query(Criteria.where("_id").is(obj.get("_id"))), (UpdateDefinition) obj,"template");
            return true;
        }
        return false;
    }

    /**
     * 删除模板
     * @param id
     * @return
     */
    @Override
    public boolean deleteTemplate(String id) {
//        if (mongoTemplate.exists(new Query(Criteria.where("_id").is(id)), "template")) {
//            DeleteResult remove = mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), "template");
//            if (remove.getDeletedCount() > 0) {
//                mongoTemplate.dropCollection(remove.);
//            }
//            return true;
//        }
        Document template = mongoTemplate.findById(id, Document.class, "template");
        if (template!= null) {
            DeleteResult remove = mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), "template");
            if (remove.getDeletedCount() > 0) {
                mongoTemplate.dropCollection((String) template.get("templateName"));
            }
            return true;
        }
        return false;
    }

    /**
     * 获取模板信息通过ID
     * @param id
     * @return
     */
    @Override
    public List<Document> getTemplateById(String id) {

        if (mongoTemplate.exists(new Query(Criteria.where("_id").is(id)), "template")) {
            List<Document> list = mongoTemplate.find(new Query(Criteria.where("_id").is(id)), Document.class, "template");
            return list;
        }

        return null;
    }
}
