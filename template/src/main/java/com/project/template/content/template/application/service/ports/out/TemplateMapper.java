package com.project.template.content.template.application.service.ports.out;

import com.project.template.content.template.application.service.TemplateCommand;
import com.project.template.content.template.domain.models.Template;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TemplateMapper {
    TemplateMapper INSTANCE = Mappers.getMapper(TemplateMapper.class);

    Template toDomainModel(TemplateCommand templateCommand);

    TemplateCommand toCommand(Template template);
}
