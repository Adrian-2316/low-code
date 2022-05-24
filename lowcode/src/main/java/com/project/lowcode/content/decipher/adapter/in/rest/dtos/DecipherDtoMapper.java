package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import com.project.lowcode.content.decipher.domain.models.Decipher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DecipherDtoMapper {
    DecipherDtoMapper INSTANCE = Mappers.getMapper(DecipherDtoMapper.class);

    DecipherDto toDto(Decipher decipher);

    Decipher toDomainModel(DecipherDto decipherDto);
}
