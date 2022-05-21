package com.project.lowcode.content.json.application.ports.out;

import com.project.lowcode.content.json.application.ports.in.commands.FieldCommand;
import com.project.lowcode.content.json.application.ports.in.commands.JsonCommand;
import com.project.lowcode.content.json.domain.models.Field;
import com.project.lowcode.content.json.domain.models.Json;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JsonMapper {
    JsonMapper INSTANCE = Mappers.getMapper(JsonMapper.class);

    Json toDomainModel(JsonCommand jsonCommand);


    Field[] toEntities(FieldCommand[] fieldCommand);

    Field[] toDomainModels(JsonCommand[] jsonCommand);
}
