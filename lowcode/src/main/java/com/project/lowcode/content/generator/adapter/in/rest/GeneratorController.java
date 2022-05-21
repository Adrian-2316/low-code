package com.project.lowcode.content.generator.adapter.in.rest;

import com.project.lowcode.content.generator.application.ports.in.GeneratorPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@Tag(name = "Generator", description = "Generate databases, schemas, collections, tabs, etc...")
@RequestMapping("api/v0/generator")
public class GeneratorController {
    private GeneratorPort generatorPort;

    @GetMapping("/database")
    public void generateDatabase(@RequestParam String company) throws SQLException {
        generatorPort.generateDatabase(company);
    }

    @GetMapping("/schema")
    public void generateSchema(@RequestParam String company, @RequestParam String app) throws SQLException {
        generatorPort.generateSchema(company, app);
    }

    @GetMapping("/tabs")
    public void generateTabs(@RequestBody List<String> tabs) {
        generatorPort.generateTabs(tabs);
    }

}

