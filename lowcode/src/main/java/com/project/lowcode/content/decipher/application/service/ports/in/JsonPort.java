package com.project.lowcode.content.decipher.application.service.ports.in;

import com.project.lowcode.content.decipher.domain.models.Decipher;

public interface JsonPort {

    Decipher save(Decipher decipher);

    Decipher get(String id);

    Decipher update(String id, Decipher toDomainModel);

    void patch(String id, Decipher toDomainModel);
}
