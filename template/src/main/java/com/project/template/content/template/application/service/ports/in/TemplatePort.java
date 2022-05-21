package com.project.template.content.template.application.service.ports.in;

import com.project.template.content.template.application.service.TemplateCommand;

public interface TemplatePort {
    TemplateCommand getTemplate(Long id);

    TemplateCommand createTemplate(TemplateCommand templateCommand);

    TemplateCommand updateTemplate(Long id, TemplateCommand templateCommand);

    void deleteTemplate(Long id);
}
