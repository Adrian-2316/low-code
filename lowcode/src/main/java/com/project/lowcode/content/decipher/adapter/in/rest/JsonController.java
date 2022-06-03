package com.project.lowcode.content.decipher.adapter.in.rest;


import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDto;
import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDtoMapper;
import com.project.lowcode.content.decipher.application.service.ports.in.JsonPort;
import com.project.lowcode.content.decipher.domain.models.Decipher;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@Tag(name = "Json", description = "Json CRUD operations")
@RequestMapping("api/v0/json")
public class JsonController {
    private JsonPort jsonPort;

    @PostMapping("/")
    public DecipherDto save(@RequestBody @Valid DecipherDto decipherDto) {
        Decipher save = jsonPort.save(DecipherDtoMapper.INSTANCE.toDomainModel(decipherDto));
        return DecipherDtoMapper.INSTANCE.toDto(save);
    }

    @GetMapping("{id}")
    public DecipherDto get(@PathVariable("id") String id) {
        return DecipherDtoMapper.INSTANCE.toDto(jsonPort.get(id));
    }

    @PutMapping("{id}")
    public DecipherDto update(@PathVariable("id") String id, @RequestBody DecipherDto decipherDto) {
        Decipher update = jsonPort.update(id, DecipherDtoMapper.INSTANCE.toDomainModel(decipherDto));
        return DecipherDtoMapper.INSTANCE.toDto(update);
    }

    @PatchMapping("{id}")
    public DecipherDto patch(@PathVariable("id") String id, @RequestBody DecipherDto decipherDto) {
        Decipher patch = jsonPort.patch(id, DecipherDtoMapper.INSTANCE.toDomainModel(decipherDto));
        return DecipherDtoMapper.INSTANCE.toDto(patch);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        jsonPort.delete(id);
    }
}
