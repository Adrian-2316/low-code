package com.project.lowcode.content.decipher.application.service;

import com.project.lowcode.content.decipher.application.service.ports.in.JsonPort;
import com.project.lowcode.content.decipher.application.service.ports.out.JsonRepositoryPort;
import com.project.lowcode.content.decipher.domain.models.Decipher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JsonService implements JsonPort {
    private JsonRepositoryPort jsonRepositoryPort;

    @Override
    public Decipher save(Decipher decipher) {
        return jsonRepositoryPort.save(decipher);
    }

    @Override
    public Decipher get(String id) {
        return jsonRepositoryPort.get(id);
    }

    @Override
    public Decipher update(String id, Decipher decipher) {
        return jsonRepositoryPort.update(id, decipher);
    }

    @Override
    public void patch(String id, Decipher decipher) {
        jsonRepositoryPort.patch(id, decipher);
    }

}
