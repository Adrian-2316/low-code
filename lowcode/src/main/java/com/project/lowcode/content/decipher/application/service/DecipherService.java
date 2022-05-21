package com.project.lowcode.content.decipher.application.service;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDto;
import com.project.lowcode.content.decipher.application.service.ports.in.DecipherPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DecipherService implements DecipherPort {
    @Override
    public void decipher(DecipherDto decipherDto) {

    }
}
