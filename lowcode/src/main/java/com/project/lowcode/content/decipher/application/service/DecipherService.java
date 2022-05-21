package com.project.lowcode.content.decipher.application.service;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDto;
import com.project.lowcode.content.decipher.application.service.logic.ModuleUtil;
import com.project.lowcode.content.decipher.application.service.ports.in.DecipherPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
public class DecipherService implements DecipherPort {

    @Override
    public void decipher(DecipherDto decipherDto) throws IOException {
        ModuleUtil.cloneModule(decipherDto.getBackend().getName());
        ModuleUtil.replaceFiles(decipherDto.getBackend().getName());

    }
}
