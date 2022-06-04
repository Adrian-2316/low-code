package com.project.module.content.template.adapter.in.rest.dtos;

import com.project.module.content.template.domain.models.Template;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TemplateDtoMapper {
    TemplateDtoMapper INSTANCE = Mappers.getMapper(TemplateDtoMapper.class);

    TemplateDto toDto(Template template);

    Template toDomainModel(TemplateDto templateDto);
}
