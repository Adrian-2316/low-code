package com.project.lowcode.content.generator.adapter.out.persistence;

import com.project.lowcode.content.generator.application.ports.out.GeneratorRepositoryPort;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class GeneratorRepository implements GeneratorRepositoryPort {

    @Override
    public void generateDatabase(String company) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "admin");
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE DATABASE " + company);
    }

    @Override
    public void generateSchema(String company, String app) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + company, "postgres", "admin");
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS " + app);
    }

    @Override
    public void generateTabs(List<String> tabs) {

    }

}
