package com.project.lowcode.content.decipher.application.service;

import com.project.lowcode.content.decipher.adapter.out.persistence.entities.DecipherEntity;
import com.project.lowcode.content.decipher.adapter.out.persistence.entities.DecipherEntityMapper;
import com.project.lowcode.content.decipher.application.service.logic.EntityUtil;
import com.project.lowcode.content.decipher.application.service.logic.ModuleUtil;
import com.project.lowcode.content.decipher.application.service.ports.in.DecipherPort;
import com.project.lowcode.content.decipher.application.service.ports.out.DecipherRepositoryPort;
import com.project.lowcode.content.decipher.domain.models.Decipher;
import com.project.lowcode.content.decipher.domain.models.backend.Entity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
public class DecipherService implements DecipherPort {
    private DecipherRepositoryPort decipherRepositoryPort;

    @Override
    public Decipher save(Decipher decipher) {
        DecipherEntity decipherEntity = DecipherEntityMapper.INSTANCE.toEntity(decipher);
        return DecipherEntityMapper.INSTANCE.toDomainModel(decipherRepositoryPort.save(decipherEntity));
    }

    @Override
    public Decipher get(String id) {
        return DecipherEntityMapper.INSTANCE.toDomainModel(decipherRepositoryPort.get(id));
    }

    @Override
    public void update(String id, Decipher toDomainModel) {
        DecipherEntity decipherEntity = DecipherEntityMapper.INSTANCE.toEntity(toDomainModel);
        decipherEntity.setId(id);
        decipherRepositoryPort.save(decipherEntity);
    }

    @Override
    public void patch(String id, Decipher toDomainModel) {
        DecipherEntity savedDecipherEntity = decipherRepositoryPort.get(id);
        DecipherEntity decipherEntity = DecipherEntityMapper.INSTANCE.toEntity(toDomainModel);
        savedDecipherEntity.update(decipherEntity);

        decipherRepositoryPort.save(decipherEntity);
    }

    @Override
    public void decipher(Decipher decipher) throws IOException, InterruptedException {
        buildModule(decipher);
        buildEntities(decipher);
        buildFields(decipher);
    }

    private void buildFields(Decipher decipher) throws IOException {
        EntityUtil.addConstructorFields(decipher);
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
