package com.formSysytem.service;

import com.formSysytem.entity.Template;
import org.springframework.data.domain.Page;

public interface TemplateService {
    Page<Template> findAllList(Integer page, Integer limit);

    Template findById(String id);

    boolean updataTemplateName(Template templateName);
}
