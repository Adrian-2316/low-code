package com.project.template.content.template.application.service;

import com.project.template.content.template.application.service.ports.in.TemplatePort;
import com.project.template.content.template.application.service.ports.out.TemplateMapper;
import com.project.template.content.template.application.service.ports.out.TemplateRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TemplateService implements TemplatePort {
    private TemplateRepositoryPort templateRepositoryPort;

    @Override
    public TemplateCommand getTemplate(Long id) {
        return TemplateMapper.INSTANCE.toCommand(templateRepositoryPort.getTemplate(id));
    }

    @Override
    public TemplateCommand createTemplate(TemplateCommand templateCommand) {
        return TemplateMapper.INSTANCE.toCommand(templateRepositoryPort.createTemplate(TemplateMapper.INSTANCE.toDomainModel(templateCommand)));
    }

    @Override
    public TemplateCommand updateTemplate(Long id, TemplateCommand templateCommand) {
        return TemplateMapper.INSTANCE.toCommand(templateRepositoryPort.updateTemplate(id, TemplateMapper.INSTANCE.toDomainModel(templateCommand)));
    }

    @Override
    public void deleteTemplate(Long id) {
        templateRepositoryPort.deleteTemplate(id);
    }
}
