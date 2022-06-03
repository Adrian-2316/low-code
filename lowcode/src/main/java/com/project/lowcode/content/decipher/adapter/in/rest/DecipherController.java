package com.project.lowcode.content.decipher.adapter.in.rest;

import com.project.lowcode.content.decipher.application.service.ports.in.DecipherPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.io.IOException;


@AllArgsConstructor
@RestController
@Tag(name = "Decipher", description = "Decipher Json into modules, files...")
@RequestMapping("api/v0/decipher")
public class DecipherController {
    private DecipherPort decipherPort;

    @PostMapping("{id}")
    public void decipher(@PathVariable String id) throws IOException, ValidationException, InterruptedException, IllegalAccessException {
        decipherPort.decipher(id);
    }
}
