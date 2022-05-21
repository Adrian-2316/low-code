package com.project.lowcode.content.generator.application.ports.out;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface GeneratorRepositoryPort {
    void generateDatabase(String company) throws SQLException;

    void generateSchema(String company, String app) throws SQLException;

}

