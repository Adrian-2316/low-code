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

    /**
     * Main implementation of decipher service.
     *
     * @param id - ID from the json to decipher.
     * @throws IOException            - if json file is not found.
     * @throws InterruptedException   - if thread is interrupted.
     * @throws IllegalAccessException - if module is not found.
     */
    @Override
    public void decipher(String id) throws IOException, InterruptedException, IllegalAccessException {
        Decipher decipher = jsonRepositoryPort.get(id);
        buildModule(decipher);
        buildEntities(decipher);
        buildFields(decipher);
    }

    /**
     * Main build module method.
     *
     * @param decipher - Decipher entity.
     * @throws IOException - If the file cannot be read or written.
     */
    private void buildModule(Decipher decipher) throws IOException {
        ModuleUtil.cloneModule(decipher.getBackend().getName());
        ModuleUtil.replaceFolders(decipher.getBackend().getName());
        ModuleUtil.replaceFiles(decipher.getBackend().getName());
    }

    /**
     * Main build entities method.
     *
     * @param decipher - Decipher entity.
     * @throws IOException - If the file cannot be read or written.
     */
    private void buildEntities(Decipher decipher) throws IOException {
        for (Entity entity : decipher.getBackend().getEntity()) {
            EntityUtil.cloneContent(decipher.getBackend().getName(), entity.getName());
            EntityUtil.replaceFolders(decipher.getBackend().getName(), entity.getName());
            EntityUtil.replaceFiles(decipher.getBackend().getName(), entity.getName());
        }
    }

    /**
     * Main build fields method.
     *
     * @param decipher - Decipher entity.
     * @throws IOException - If the file cannot be read or written.
     */
    private void buildFields(Decipher decipher) throws IOException {
        EntityUtil.addClassLines(decipher);
    }
}
