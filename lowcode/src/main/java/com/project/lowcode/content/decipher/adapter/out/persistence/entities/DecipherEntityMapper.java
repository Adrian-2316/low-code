package com.project.lowcode.content.decipher.adapter.out.persistence.entities;

import com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend.BackendEntity;
import com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend.FrontendEntity;
import com.project.lowcode.content.decipher.domain.models.Decipher;
import com.project.lowcode.content.decipher.domain.models.backend.Backend;
import com.project.lowcode.content.decipher.domain.models.frontend.Frontend;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DecipherEntityMapper {
    DecipherEntityMapper INSTANCE = Mappers.getMapper(DecipherEntityMapper.class);

    DecipherEntity toEntity(Decipher decipher);

    Decipher toDomainModel(DecipherEntity save);

    Frontend toDomainModel(FrontendEntity save);

    Backend toDomainModel(BackendEntity save);

}

