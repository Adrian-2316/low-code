package com.project.module.content.template.adapter.out.persistence;

import com.project.module.content.template.adapter.out.persistence.entity.TemplateEntity;
import com.project.module.content.template.adapter.out.persistence.entity.TemplateEntityMapper;
import com.project.module.content.template.application.service.ports.out.TemplateRepositoryPort;
import com.project.module.content.template.domain.models.Template;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class TemplateRepository implements TemplateRepositoryPort {
    private TemplateJpaRepository templateJpaRepository;

    @Override
    public Template getTemplate(Long id) {
        return TemplateEntityMapper.INSTANCE.toDomainModel(templateJpaRepository.findById(id).orElse(null));
    }

    @Override
    public Template createTemplate(Template template) {
        return TemplateEntityMapper.INSTANCE.toDomainModel(templateJpaRepository.save(TemplateEntityMapper.INSTANCE.toEntity(template)));
    }

    @Override
    public Template updateTemplate(Long id, Template template) {
        Optional<TemplateEntity> existingTemplate = templateJpaRepository.findById(id);
        if (existingTemplate.isPresent()) {
            TemplateEntity templateEntity = existingTemplate.get();
            templateEntity.copyProperties(template);
            return TemplateEntityMapper.INSTANCE.toDomainModel(templateJpaRepository.save(templateEntity));
        }
        return TemplateEntityMapper.INSTANCE.toDomainModel(templateJpaRepository.save(TemplateEntityMapper.INSTANCE.toEntity(template)));
    }

    @Override
    public Template patchTemplate(Template template) {
        Optional<TemplateEntity> existingTemplate = templateJpaRepository.findById(template.getId());
        if (existingTemplate.isPresent()) {
            TemplateEntity templateEntity = existingTemplate.get();
            templateEntity.copyProperties(template);
            return TemplateEntityMapper.INSTANCE.toDomainModel(templateJpaRepository.save(templateEntity));
        }
        return TemplateEntityMapper.INSTANCE.toDomainModel(templateJpaRepository.save(TemplateEntityMapper.INSTANCE.toEntity(template)));
    }

    @Override
    public void deleteTemplate(Long id) {
        templateJpaRepository.deleteById(id);
    }
}
