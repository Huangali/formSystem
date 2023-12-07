package com.formSysytem.repository;

import com.formSysytem.entity.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author U
 * @className: templateRepository
 * @description: TODO
 * @date 2023/11/19 23:00
 */
public interface TemplateRepository extends MongoRepository<Template,String> {
}
