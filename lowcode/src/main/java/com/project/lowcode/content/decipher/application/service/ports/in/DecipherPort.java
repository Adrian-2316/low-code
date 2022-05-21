package com.project.lowcode.content.decipher.application.service.ports.in;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDto;

import java.io.IOException;

public interface DecipherPort {
    void decipher(DecipherDto decipherDto) throws IOException;
}
