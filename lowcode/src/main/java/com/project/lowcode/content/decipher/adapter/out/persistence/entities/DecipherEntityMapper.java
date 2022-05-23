package com.project.lowcode.content.decipher.adapter.out.persistence.entities;

import com.project.lowcode.content.decipher.domain.models.Decipher;
import com.project.lowcode.content.json.adapter.out.persistence.entities.FieldEntity;
import com.project.lowcode.content.json.domain.models.Field;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DecipherEntityMapper {
    DecipherEntityMapper INSTANCE = Mappers.getMapper(DecipherEntityMapper.class);

    DecipherEntity toEntity(Decipher decipher);

    FieldEntity mapToEntity(Field field);

    Decipher toDomainModel(DecipherEntity decipherEntity);

    FieldEntity[] toEntities(Field[] field);

    Field[] toDomainModels(FieldEntity[] field);
}
