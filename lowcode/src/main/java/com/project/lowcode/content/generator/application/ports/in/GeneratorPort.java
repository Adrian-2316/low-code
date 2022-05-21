package com.project.lowcode.content.generator.application.ports.in;


import java.sql.SQLException;
import java.util.List;

public interface GeneratorPort {
    void generateDatabase(String company) throws SQLException;

    void generateSchema(String company, String app) throws SQLException;

    void generateTabs(List<String> tabs);
}
