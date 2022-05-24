package com.project.lowcode.content.generator.application.ports.in;


import java.sql.SQLException;

public interface GeneratorPort {
    void generateDatabase(String company) throws SQLException;

    void generateSchema(String company, String app) throws SQLException;

    void generateCollection(String collection);
}
