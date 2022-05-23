package com.project.lowcode.content.decipher.application.service.ports.out.out;

import com.project.lowcode.content.json.domain.models.Json;

public interface DecipherRepositoryPort {
    void generateCollection(String collection);

    Json generateDocument(Json json);
}

