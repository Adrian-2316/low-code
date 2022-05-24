package com.project.lowcode.content.decipher.application.service.ports.in;

import com.project.lowcode.content.decipher.domain.models.Decipher;

import java.io.IOException;

public interface DecipherPort {
    void decipher(Decipher decipher) throws IOException, InterruptedException;

    Decipher save(Decipher decipher);

    Decipher get(String id);

    void update(String id, Decipher toDomainModel);

    void patch(String id, Decipher toDomainModel);
}
