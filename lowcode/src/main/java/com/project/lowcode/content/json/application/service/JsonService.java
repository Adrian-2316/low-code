package com.project.lowcode.content.json.application.service;

import com.project.lowcode.content.json.application.ports.in.JsonPort;
import com.project.lowcode.content.json.application.ports.in.commands.JsonCommand;
import com.project.lowcode.content.json.application.ports.out.JsonMapper;
import com.project.lowcode.content.json.application.ports.out.JsonRepositoryPort;
import com.project.lowcode.content.json.domain.models.Json;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JsonService implements JsonPort {
    private JsonRepositoryPort jsonRepositoryPort;

    @Override
    public void generateCollection(String collection) {
        jsonRepositoryPort.generateCollection(collection);
    }

    @Override
    public Json generateDocument(JsonCommand jsonCommand) {
        Json json = JsonMapper.INSTANCE.toDomainModel(jsonCommand);
        return jsonRepositoryPort.generateDocument(json);
    }


}
