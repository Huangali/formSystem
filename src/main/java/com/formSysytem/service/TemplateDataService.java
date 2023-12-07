package com.formSysytem.service;

import org.bson.Document;

import java.util.List;
import java.util.Map;

public interface TemplateDataService {
    Map<String, Object> findAllList(String templateName, Integer page, Integer limit);

    boolean saveTemplateData(String _id, Map<String, Object> templateData, String templateDataId);

    boolean delete(String id, String dataId);

    List<Document> getDataById(String id, String dataId);

}
