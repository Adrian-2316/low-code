package com.project.lowcode.content.decipher.application.service.ports.out;

import com.project.lowcode.content.decipher.domain.models.Decipher;

public interface JsonRepositoryPort {
    Decipher save(Decipher decipher);

    Decipher get(String id);

    void patch(String id, Decipher decipher);

    Decipher update(String id, Decipher decipher);
}

