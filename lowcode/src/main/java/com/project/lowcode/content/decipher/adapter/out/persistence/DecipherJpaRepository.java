package com.project.lowcode.content.decipher.adapter.out.persistence;

import com.project.lowcode.content.decipher.adapter.out.persistence.entities.DecipherEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecipherJpaRepository extends MongoRepository<DecipherEntity, Long> {

}
