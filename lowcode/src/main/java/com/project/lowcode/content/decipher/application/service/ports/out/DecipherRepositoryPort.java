package com.project.lowcode.content.decipher.application.service.ports.out;

import com.project.lowcode.content.decipher.adapter.out.persistence.entities.DecipherEntity;

public interface DecipherRepositoryPort {
    void generateCollection(String collection);

    DecipherEntity generateDocument(DecipherEntity decipher);

    DecipherEntity save(DecipherEntity decipher);

    DecipherEntity get(String id);
}

