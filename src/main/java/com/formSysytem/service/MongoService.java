package com.formSysytem.service;

import org.bson.Document;

import java.util.List;
import java.util.Map;

public interface MongoService {
    int insert(List<Map<String, Object>> document, String id);

    List<Document> getTemplate(String id);

    boolean updateTemplate(Map<String, Object> obj);

    boolean deleteTemplate(String id);

    List<Document> getTemplateById(String id);
}
