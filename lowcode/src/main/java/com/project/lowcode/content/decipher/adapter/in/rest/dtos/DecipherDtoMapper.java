package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import com.project.lowcode.content.decipher.domain.models.Backend;
import com.project.lowcode.content.decipher.domain.models.Decipher;
import com.project.lowcode.content.decipher.domain.models.Entity;
import com.project.lowcode.content.decipher.domain.models.Frontend;
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

    List<EntityDto> toDtos(List<Entity> entity);


    Decipher toDomainModel(DecipherDto decipherDto);

    Backend toDomainModel(BackendDto backendDto);

    Frontend toDomainModel(FrontendDto frontendDto);

    Entity toDomainModel(EntityDto entityDto);

    List<Entity> toDomainModels(List<EntityDto> entityDtos);
}
