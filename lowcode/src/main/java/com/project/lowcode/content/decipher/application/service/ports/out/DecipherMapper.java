package com.project.lowcode.content.decipher.application.service.ports.out;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDto;
import com.project.lowcode.content.decipher.domain.models.Decipher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DecipherMapper {
    DecipherMapper INSTANCE = Mappers.getMapper(DecipherMapper.class);

    Decipher toDomainModel(DecipherDto decipherCommand);
}
