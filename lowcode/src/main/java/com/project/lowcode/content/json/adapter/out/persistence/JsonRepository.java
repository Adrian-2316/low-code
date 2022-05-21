package com.project.lowcode.content.json.adapter.out.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.project.lowcode.content.json.adapter.out.persistence.entities.JsonEntity;
import com.project.lowcode.content.json.adapter.out.persistence.entities.JsonEntityMapper;
import com.project.lowcode.content.json.application.service.ports.out.JsonRepositoryPort;
import com.project.lowcode.content.json.domain.models.Json;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JsonRepository implements JsonRepositoryPort {
    private JsonJpaRepository jsonJpaRepository;

    @Override
    public void generateCollection(String collection) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase(collection);
        database.createCollection(collection);
    }

    @Override
    public Json generateDocument(Json json) {
        JsonEntity jsonEntity = JsonEntityMapper.INSTANCE.toEntity(json);
        return JsonEntityMapper.INSTANCE.toDomainModel(jsonJpaRepository.save(jsonEntity));
    }
}