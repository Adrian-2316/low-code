package com.project.lowcode.content.generator.application.ports.out;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface GeneratorRepositoryPort {
    void generateDatabase(String company) throws SQLException;

    void generateSchema(String company, String app) throws SQLException;

    void generateTabs(List<String> tabs);
}

