package com.project.lowcode.content.json.application.ports.in;

import com.project.lowcode.content.json.application.ports.in.commands.JsonCommand;
import com.project.lowcode.content.json.domain.models.Json;

public interface JsonPort {
    void generateCollection(String collection);

    Json generateDocument(JsonCommand command);
}
