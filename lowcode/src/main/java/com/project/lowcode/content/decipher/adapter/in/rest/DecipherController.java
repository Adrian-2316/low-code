package com.project.lowcode.content.decipher.adapter.in.rest;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.DecipherDto;
import com.project.lowcode.content.decipher.application.service.ports.in.DecipherPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Tag(name = "Decipher", description = "Decipher Json into modules, files...")
@RequestMapping("api/v0/decipher")
public class DecipherController {

    private DecipherPort decipherPort;

    @PostMapping("/decipher")
    public void decipher(DecipherDto decipherDto) {
        decipherPort.decipher(decipherDto);
    }

}