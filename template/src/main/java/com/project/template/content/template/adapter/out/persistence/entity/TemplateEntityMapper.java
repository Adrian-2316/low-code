package com.project.template.content.template.adapter.out.persistence.entity;

import com.project.template.content.template.domain.models.Template;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TemplateEntityMapper {
    TemplateEntityMapper INSTANCE = Mappers.getMapper(TemplateEntityMapper.class);

    TemplateEntity toEntity(Template template);

    Template toDomainModel(TemplateEntity templateEntity);

}
