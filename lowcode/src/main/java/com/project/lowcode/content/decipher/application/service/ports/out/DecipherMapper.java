package com.project.lowcode.content.decipher.application.service.ports.out;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DecipherMapper {
    DecipherMapper INSTANCE = Mappers.getMapper(DecipherMapper.class);

}
