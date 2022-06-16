package com.project.lowcode.content.decipher.adapter.out.persistence.entities;

import com.project.lowcode.content.decipher.domain.models.Decipher;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JsonEntityMapper {
    JsonEntityMapper INSTANCE = Mappers.getMapper(JsonEntityMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "id", ignore = true)
    void partialUpdate(JsonEntity newJson
            , @MappingTarget JsonEntity jsonEntity);

    JsonEntity toEntity(Decipher decipher);

    Decipher toDomainModel(JsonEntity json);

}

