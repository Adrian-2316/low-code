package com.project.lowcode.content.decipher.adapter.out.persistence;


import com.project.lowcode.content.decipher.adapter.out.persistence.entities.JsonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonJpaRepository extends MongoRepository<JsonEntity, String> {

}
