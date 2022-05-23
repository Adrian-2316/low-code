package com.project.lowcode.content.json.application.service.ports.out;

import com.project.lowcode.content.json.application.service.commands.JsonCommand;
import com.project.lowcode.content.json.domain.models.Json;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JsonMapper {
    JsonMapper INSTANCE = Mappers.getMapper(JsonMapper.class);

    Json toDomainModel(JsonCommand jsonCommand);

    JsonCommand toCommand(Json json);
}
