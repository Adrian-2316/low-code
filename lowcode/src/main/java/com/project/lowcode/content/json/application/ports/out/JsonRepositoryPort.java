package com.project.lowcode.content.json.application.ports.out;

import com.project.lowcode.content.json.domain.models.Json;

public interface JsonRepositoryPort {
    void generateCollection(String collection);

    Json generateDocument(Json json);
}

