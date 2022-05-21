package com.project.lowcode.content.json.adapter.in.rest;

import com.project.lowcode.content.json.adapter.in.rest.dtos.JsonDto;
import com.project.lowcode.content.json.adapter.in.rest.dtos.JsonDtoMapper;
import com.project.lowcode.content.json.application.ports.in.JsonPort;
import com.project.lowcode.content.json.application.ports.in.commands.JsonCommand;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Tag(name = "Json", description = "Generate collections, documents...")
@RequestMapping("api/v0/json")
public class JsonController {

    private JsonPort jsonPort;

    @GetMapping("/collection")
    public void generateCollection(@RequestParam String collection) {
        jsonPort.generateCollection(collection);
    }

    @PostMapping("/document")
    public JsonDto generateDocument(@RequestBody JsonDto jsonDto) {
        JsonCommand command = JsonDtoMapper.INSTANCE.toCommand(jsonDto);
        return JsonDtoMapper.INSTANCE.toDto(jsonPort.generateDocument(command));
    }
}
