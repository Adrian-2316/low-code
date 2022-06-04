package com.project.module.content.template.application.service;

// Generation import code segment start
// Generation import code segment end

import com.project.module.content.template.application.service.ports.in.TemplatePort;
import com.project.module.content.template.application.service.ports.out.TemplateRepositoryPort;
import com.project.module.content.template.domain.models.Template;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TemplateService implements TemplatePort {
    private TemplateRepositoryPort templateRepositoryPort;

    @Override
    public Template getTemplate(Long id) {
        return templateRepositoryPort.getTemplate(id);
    }

    @Override
    public Template createTemplate(Template template) {
        return templateRepositoryPort.createTemplate(template);
    }

    @Override
    public Template updateTemplate(Long id, Template template) {
        return templateRepositoryPort.updateTemplate(id, template);
    }

    @Override
    public Template patchTemplate(Template template) {
        return templateRepositoryPort.patchTemplate(template);
    }

    @Override
    public void deleteTemplate(Long id) {
        templateRepositoryPort.deleteTemplate(id);
    }
}
