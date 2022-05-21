package com.project.template.content.template.adapter.in.rest.dtos;

import com.project.template.content.template.application.service.TemplateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TemplateDtoMapper {
    TemplateDtoMapper INSTANCE = Mappers.getMapper(TemplateDtoMapper.class);

    TemplateDto toDto(TemplateCommand templateCommand);

    TemplateCommand toCommand(TemplateDto templateDto);
}
