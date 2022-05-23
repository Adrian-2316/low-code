package com.project.lowcode.content.decipher.adapter.out.persistence.entities;

import com.project.lowcode.content.json.adapter.out.persistence.entities.FieldEntity;
import com.project.lowcode.content.json.domain.models.Field;
import com.project.lowcode.content.json.domain.models.Json;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DecipherEntityMapper {
    DecipherEntityMapper INSTANCE = Mappers.getMapper(DecipherEntityMapper.class);

    DecipherEntity toEntity(Json json);

    FieldEntity mapToEntity(Field field);

    Json toDomainModel(DecipherEntity jsonEntity);

    FieldEntity[] toEntities(Field[] field);

    Field[] toDomainModels(FieldEntity[] field);
}
