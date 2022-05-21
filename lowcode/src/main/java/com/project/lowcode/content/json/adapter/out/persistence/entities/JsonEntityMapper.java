package com.project.lowcode.content.json.adapter.out.persistence.entities;

import com.project.lowcode.content.json.domain.models.Field;
import com.project.lowcode.content.json.domain.models.Json;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JsonEntityMapper {
    JsonEntityMapper INSTANCE = Mappers.getMapper(JsonEntityMapper.class);

    JsonEntity toEntity(Json json);

    FieldEntity mapToEntity(Field field);

    Json toDomainModel(JsonEntity jsonEntity);

    FieldEntity[] toEntities(Field[] field);

    Field[] toDomainModels(FieldEntity[] field);
}
