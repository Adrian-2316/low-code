package com.project.lowcode.content.decipher.application.service.ports.in;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDto;

public interface DecipherPort {
    void decipher(DecipherDto decipherDto);
}
