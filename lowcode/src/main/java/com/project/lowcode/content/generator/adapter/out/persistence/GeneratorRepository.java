package com.project.lowcode.content.generator.adapter.out.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.project.lowcode.content.generator.application.ports.out.GeneratorRepositoryPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class GeneratorRepository implements GeneratorRepositoryPort {

    @Value("${spring.data.url}")
    private String databaseUrl;

    @Value("${spring.data.username}")
    private String databaseUsername;

    @Value("${spring.data.password}")
    private String databasePassword;

    @Override
    public void generateDatabase(String company) throws SQLException {
        Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE DATABASE " + company);
    }

    @Override
    public void generateSchema(String company, String app) throws SQLException {
        Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS " + app);
    }

    @Override
    public void generateCollection(String collection) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase(collection);
        database.createCollection(collection);
    }
}
