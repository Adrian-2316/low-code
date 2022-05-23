package com.project.lowcode.content.decipher.application.service.ports.out.out;

import com.project.lowcode.content.json.application.service.commands.JsonCommand;
import com.project.lowcode.content.json.domain.models.Json;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DecipherMapper {
    com.project.lowcode.content.decipher.application.service.ports.out.out.DecipherMapper INSTANCE = Mappers.getMapper(com.project.lowcode.content.decipher.application.service.ports.out.out.DecipherMapper.class);

    Json toDomainModel(JsonCommand jsonCommand);

    JsonCommand toCommand(Json json);
}
