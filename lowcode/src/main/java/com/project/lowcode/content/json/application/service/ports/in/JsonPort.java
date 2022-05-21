package com.project.lowcode.content.json.application.service.ports.in;

import com.project.lowcode.content.json.application.service.commands.JsonCommand;
import com.project.lowcode.content.json.domain.models.Json;

public interface JsonPort {
    void generateCollection(String collection);

    Json generateDocument(JsonCommand command);
}
