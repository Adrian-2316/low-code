package com.project.lowcode.content.decipher.application.service;

import com.project.lowcode.content.decipher.application.service.logic.EntityUtil;
import com.project.lowcode.content.decipher.application.service.logic.ModuleUtil;
import com.project.lowcode.content.decipher.application.service.ports.in.DecipherPort;
import com.project.lowcode.content.decipher.application.service.ports.out.JsonRepositoryPort;
import com.project.lowcode.content.decipher.domain.models.Decipher;
import com.project.lowcode.content.decipher.domain.models.backend.Entity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
public class DecipherService implements DecipherPort {
    private JsonRepositoryPort jsonRepositoryPort;

    @Override
    public void decipher(String id) throws IOException, InterruptedException, IllegalAccessException {
        Decipher decipher = jsonRepositoryPort.get(id);
        buildModule(decipher);
        buildEntities(decipher);
        buildFields(decipher);
    }

    private void buildFields(Decipher decipher) throws IOException, IllegalAccessException {
        EntityUtil.addConstructorLines(decipher);
    }

    private void buildEntities(Decipher decipher) throws IOException {
        for (Entity entity : decipher.getBackend().getEntity()) {
            EntityUtil.cloneModule(decipher.getBackend().getName(), entity.getName());
            EntityUtil.replaceFolders(decipher.getBackend().getName(), entity.getName());
            EntityUtil.replaceFiles(decipher.getBackend().getName(), entity.getName());
        }
    }

    private void buildModule(Decipher decipher) throws IOException {
        ModuleUtil.cloneModule(decipher.getBackend().getName());
        ModuleUtil.replaceFolders(decipher.getBackend().getName());
        ModuleUtil.replaceFiles(decipher.getBackend().getName());
    }
}
