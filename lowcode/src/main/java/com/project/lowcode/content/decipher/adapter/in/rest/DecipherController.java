package com.project.lowcode.content.decipher.adapter.in.rest;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDto;
import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDtoMapper;
import com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend.EntityDto;
import com.project.lowcode.content.decipher.application.service.ports.in.DecipherPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.io.IOException;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@Tag(name = "Decipher", description = "Decipher Json into modules, files...")
@RequestMapping("api/v0/decipher")
public class DecipherController {

    private DecipherPort decipherPort;

    @PostMapping("/json")
    public void save(@RequestBody @Valid DecipherDto decipherDto) {
        decipherPort.save(DecipherDtoMapper.INSTANCE.toDomainModel(decipherDto));
    }

    @GetMapping("/json/{id}")
    public DecipherDto get(@PathVariable("id") String id) {
        return DecipherDtoMapper.INSTANCE.toDto(decipherPort.get(id));
    }

    @PutMapping("/json/{id}")
    public void update(@PathVariable("id") String id, @RequestBody DecipherDto decipherDto) {
        decipherPort.update(id, DecipherDtoMapper.INSTANCE.toDomainModel(decipherDto));
    }

    @PatchMapping("/json/{id}")
    public void patch(@PathVariable("id") String id, @RequestBody DecipherDto decipherDto) {
        decipherPort.patch(id, DecipherDtoMapper.INSTANCE.toDomainModel(decipherDto));
    }


    @PostMapping("/decipher")
    public void decipher(@RequestBody @Valid DecipherDto decipherDto) throws IOException, ValidationException, InterruptedException {
        checkValidations(decipherDto);
        decipherPort.decipher(DecipherDtoMapper.INSTANCE.toDomainModel(decipherDto));
    }

    private void checkValidations(DecipherDto decipherDto) {
        // Third level inheritance javax.validation.ValidationException
        if (decipherDto.getBackend().getName() == null) throw new ValidationException("Backend name is required.");
        if (decipherDto.getBackend().getEntity() == null) throw new ValidationException("Entity name is required.");
        decipherDto.getBackend().getEntity().stream().filter(entityDto -> entityDto.getName() == null).forEach(entityDto -> {
            throw new ValidationException("Entity name is required.");
        });
        for (EntityDto entityDto : decipherDto.getBackend().getEntity()) {
            entityDto.getFields().stream().filter(fieldDto -> fieldDto.getName() == null).filter(fieldDto -> fieldDto.getType() == null).forEach(fieldDto -> {
                throw new ValidationException("Field name and type are required.");
            });
        }
    }

}
