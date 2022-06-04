package com.project.module.content.template.application.service.ports.out;

import com.project.module.content.template.domain.models.Template;

public interface TemplateRepositoryPort {
    Template getTemplate(Long id);

    Template createTemplate(Template template);

    Template updateTemplate(Long id, Template template);

    Template patchTemplate(Template template);

    void deleteTemplate(Long id);
}

