package com.formSysytem.service.impl;

import com.formSysytem.entity.Template;
import com.formSysytem.repository.TemplateRepository;

import com.formSysytem.service.TemplateService;
import com.mongodb.MongoNamespace;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author U
 * @className: TemplateServiceImpl
 * @description: TODO
 * @date 2023/11/19 23:02
 */
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Page<Template> findAllList(Integer page, Integer limit) {

        Page<Template> all = templateRepository.findAll(PageRequest.of(page,limit));
        return all;
    }

    @Override
    public Template findById(String id) {
        Template template = templateRepository.findById(id).get();
        return template;
    }

    /**
     * 在更新模板列表的名字时，需要同时更改对应的集合名
     *
     * @param templateName
     * @return
     */
    @Override
    public boolean updataTemplateName(Template templateName) {
        //没有找到这个模板，返回false
        for (int i = 0; i < templateRepository.findAll().size(); i++) {
            if (templateRepository.findAll().get(i).getTemplateName().equals(templateName.getTemplateName())){
                return false;
            }
        }
        //找到模板
        if (templateName.get_id() != null){
            //修改模板名时，同时修改集合的名字
            Template template = templateRepository.findById(templateName.get_id()).get();
            String oldName = template.getTemplateName();
            template.setTemplateName(templateName.getTemplateName());
            template.setUpdateTime(new Date());
            templateRepository.save(template);
            MongoNamespace mongoNamespace = new MongoNamespace("form",templateName.getTemplateName());
            mongoTemplate.getCollection(oldName).renameCollection(mongoNamespace);

            return true;
        }else {
            //添加模板，同时添加一个集合
            templateName.setTemplateName(templateName.getTemplateName());
            templateName.setCreateTime(new Date());
            templateName.setUpdateTime(new Date());
            templateRepository.save(templateName);
            mongoTemplate.createCollection(templateName.getTemplateName());
            return true;
        }

    }
}
