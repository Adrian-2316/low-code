package com.project.lowcode.content.decipher.adapter.out.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.project.lowcode.content.decipher.adapter.out.persistence.entities.DecipherEntity;
import com.project.lowcode.content.decipher.adapter.out.persistence.entities.DecipherEntityMapper;
import com.project.lowcode.content.json.application.service.ports.out.JsonRepositoryPort;
import com.project.lowcode.content.json.domain.models.Json;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DecipherRepository implements JsonRepositoryPort {
    private DecipherJpaRepository jsonJpaRepository;

    @Override
    public void generateCollection(String collection) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase(collection);
        database.createCollection(collection);
    }

    @Override
    public Json generateDocument(Json json) {
        DecipherEntity jsonEntity = DecipherEntityMapper.INSTANCE.toEntity(json);
        return DecipherEntityMapper.INSTANCE.toDomainModel(jsonJpaRepository.save(jsonEntity));
    }
}
