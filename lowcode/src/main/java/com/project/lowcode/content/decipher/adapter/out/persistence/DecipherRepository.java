package com.project.lowcode.content.decipher.adapter.out.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.project.lowcode.content.decipher.adapter.out.persistence.entities.DecipherEntity;
import com.project.lowcode.content.decipher.application.service.ports.out.DecipherRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DecipherRepository implements DecipherRepositoryPort {

    private DecipherJpaRepository decipherJpaRepository;

    @Override
    public void generateCollection(String collection) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase(collection);
        database.createCollection(collection);
    }

    @Override
    public DecipherEntity generateDocument(DecipherEntity decipher) {
        return decipherJpaRepository.save(decipher);
    }

    public DecipherEntity save(DecipherEntity decipherEntity) {
        return decipherJpaRepository.save(decipherEntity);
    }

    @Override
    public DecipherEntity get(String id) {
        return decipherJpaRepository.findById(id).orElse(null);
    }
}
