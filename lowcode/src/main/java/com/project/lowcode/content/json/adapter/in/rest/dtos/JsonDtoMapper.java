package com.project.lowcode.content.json.adapter.in.rest.dtos;

import com.project.lowcode.content.json.application.service.commands.FieldCommand;
import com.project.lowcode.content.json.application.service.commands.JsonCommand;
import com.project.lowcode.content.json.domain.models.Field;
import com.project.lowcode.content.json.domain.models.Json;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JsonDtoMapper {
    JsonDtoMapper INSTANCE = Mappers.getMapper(JsonDtoMapper.class);

    JsonDto toDto(Json json);

    Json toDomainModel(JsonDto jsonDto);

    Field map(FieldDto field);

    FieldDto[] toDtos(Field[] field);

    Field[] toDomainModels(FieldDto[] field);

    FieldCommand[] toCommands(FieldDto[] fieldDto);

    JsonCommand toCommand(JsonDto jsonDto);
}
