package com.project.lowcode.content.generator.adapter.in.rest;

import com.project.lowcode.content.generator.application.ports.in.GeneratorPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


@AllArgsConstructor
@RestController
@Tag(name = "Generator", description = "Generate databases, schemas, collections, etc...")
@RequestMapping("api/v0/generator")
public class GeneratorController {
    private GeneratorPort generatorPort;

    @GetMapping("/sql/database")
    public void generateDatabase(@RequestParam String company) throws SQLException {
        generatorPort.generateDatabase(company);
    }

    @GetMapping("/sql/schema")
    public void generateSchema(@RequestParam String company, @RequestParam String app) throws SQLException {
        generatorPort.generateSchema(company, app);
    }

    @GetMapping("/mongodb/collection")
    public void generateCollection(@RequestParam String collection) {
        generatorPort.generateCollection(collection);
    }


}

