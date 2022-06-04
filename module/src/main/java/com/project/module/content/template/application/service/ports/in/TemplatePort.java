package com.project.module.content.template.application.service.ports.in;

import com.project.module.content.template.domain.models.Template;

public interface TemplatePort {
    Template getTemplate(Long id);

    Template createTemplate(Template template);

    Template updateTemplate(Long id, Template template);

    Template patchTemplate(Template template);

    void deleteTemplate(Long id);
}
