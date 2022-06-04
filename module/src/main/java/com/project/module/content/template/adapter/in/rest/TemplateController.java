package com.project.module.content.template.adapter.in.rest;

import com.project.module.content.template.adapter.in.rest.dtos.TemplateDto;
import com.project.module.content.template.adapter.in.rest.dtos.TemplateDtoMapper;
import com.project.module.content.template.application.service.ports.in.TemplatePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@RestController
@Tag(name = "Template")
@RequestMapping("api/v0/template")
public class TemplateController {
    private TemplatePort templatePort;

    @GetMapping("{id}")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public TemplateDto getTemplate(@PathVariable @NotNull Long id) {
        return TemplateDtoMapper.INSTANCE.toDto(templatePort.getTemplate(id));
    }

    @PostMapping("/")
    @Transactional(rollbackFor = Exception.class)
    public TemplateDto createTemplate(@RequestBody TemplateDto templateDto) {
        return TemplateDtoMapper.INSTANCE.toDto(templatePort.createTemplate(TemplateDtoMapper.INSTANCE.toDomainModel(templateDto)));
    }

    @PutMapping("{id}")
    @Transactional(rollbackFor = Exception.class)
    public TemplateDto updateTemplate(@PathVariable @NotNull Long id, @RequestBody @Valid TemplateDto templateDto) {
        return TemplateDtoMapper.INSTANCE.toDto(templatePort.updateTemplate(id, TemplateDtoMapper.INSTANCE.toDomainModel(templateDto)));
    }

    @PatchMapping("/")
    @Transactional(rollbackFor = Exception.class)
    public TemplateDto patchTemplate(@RequestBody @Valid TemplateDto templateDto) {
        return TemplateDtoMapper.INSTANCE.toDto(templatePort.patchTemplate(TemplateDtoMapper.INSTANCE.toDomainModel(templateDto)));
    }

    @DeleteMapping("{id}")
    public void deleteTemplate(@PathVariable @NotNull Long id) {
        templatePort.deleteTemplate(id);
    }
}
