package com.project.lowcode.content.decipher.adapter.out.persistence;


import com.project.lowcode.content.decipher.adapter.out.persistence.entities.JsonEntity;
import com.project.lowcode.content.decipher.adapter.out.persistence.entities.JsonEntityMapper;
import com.project.lowcode.content.decipher.application.service.ports.out.JsonRepositoryPort;
import com.project.lowcode.content.decipher.domain.models.Decipher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JsonRepository implements JsonRepositoryPort {
    private JsonJpaRepository jsonJpaRepository;

    public Decipher save(Decipher decipher) {
        JsonEntity jsonEntity = JsonEntityMapper.INSTANCE.toEntity(decipher);
        return JsonEntityMapper.INSTANCE.toDomainModel(jsonJpaRepository.save(jsonEntity));
    }

    @Override
    public Decipher get(String id) {
        JsonEntity jsonEntity = jsonJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Json with id " + id + " not found"));
        return JsonEntityMapper.INSTANCE.toDomainModel(jsonJpaRepository.save(jsonEntity));
    }

    @Override
    public void patch(String id, Decipher decipher) {
        JsonEntity jsonEntity = JsonEntityMapper.INSTANCE.toEntity(decipher);
        JsonEntity savedJsonEntity = jsonJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Json with id " + id + " not found"));
        JsonEntityMapper.INSTANCE.partialUpdate(jsonEntity, savedJsonEntity);
        jsonJpaRepository.save(jsonEntity);
    }

    @Override
    public Decipher update(String id, Decipher decipher) {
        return save(decipher);
    }
}
