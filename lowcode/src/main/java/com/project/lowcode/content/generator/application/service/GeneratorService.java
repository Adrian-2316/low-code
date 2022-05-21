package com.project.lowcode.content.generator.application.service;

import com.project.lowcode.content.generator.application.ports.in.GeneratorPort;
import com.project.lowcode.content.generator.application.ports.out.GeneratorRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@AllArgsConstructor
@Service
public class GeneratorService implements GeneratorPort {

    private GeneratorRepositoryPort generatorRepositoryPort;

    @Override
    public void generateDatabase(String company) throws SQLException {
        generatorRepositoryPort.generateDatabase(company);
    }

    @Override
    public void generateSchema(String company, String app) throws SQLException {
        generatorRepositoryPort.generateSchema(company, app);
    }


}
