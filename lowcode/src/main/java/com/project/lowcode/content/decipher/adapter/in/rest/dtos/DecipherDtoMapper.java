package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend.BackendDto;
import com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend.EntityDto;
import com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend.FieldDto;
import com.project.lowcode.content.decipher.adapter.in.rest.dtos.frontend.FrontendDto;
import com.project.lowcode.content.decipher.domain.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DecipherDtoMapper {
    DecipherDtoMapper INSTANCE = Mappers.getMapper(DecipherDtoMapper.class);

    DecipherDto toDto(Decipher decipher);

    FrontendDto toDto(Frontend frontend);

    BackendDto toDto(Backend backend);

    EntityDto toDto(Entity entity);

    FieldDto toDto(Field field);

    List<FieldDto> toDtos(List<Field> fields);

    Decipher toDomainModel(DecipherDto decipherDto);

    Backend toDomainModel(BackendDto backendDto);

    Frontend toDomainModel(FrontendDto frontendDto);

    Entity toDomainModel(EntityDto entityDto);

    Field toDomainModel(FieldDto entityDto);

    List<Field> toDomainModels(List<FieldDto> entityDtos);
}
