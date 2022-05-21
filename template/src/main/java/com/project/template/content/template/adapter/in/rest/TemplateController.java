package com.project.template.content.template.adapter.in.rest;

import com.project.template.content.template.adapter.in.rest.dtos.TemplateDto;
import com.project.template.content.template.adapter.in.rest.dtos.TemplateDtoMapper;
import com.project.template.content.template.application.service.ports.in.TemplatePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Tag(name = "Template")
@RequestMapping("api/v0/template")
public class TemplateController {
    private TemplatePort templatePort;

    @GetMapping("/{id}")
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public TemplateDto getTemplate(@PathVariable Long id) {
        return TemplateDtoMapper.INSTANCE.toDto(templatePort.getTemplate(id));
    }

    @PostMapping("/")
    @Transactional(rollbackFor = Exception.class)
    public TemplateDto createTemplate(@RequestBody TemplateDto templateDto) {
        return TemplateDtoMapper.INSTANCE.toDto(templatePort.createTemplate(TemplateDtoMapper.INSTANCE.toCommand(templateDto)));
    }

    @PutMapping("/{id}")
    @Transactional(rollbackFor = Exception.class)
    public TemplateDto updateTemplate(@PathVariable Long id, @RequestBody TemplateDto templateDto) {
        return TemplateDtoMapper.INSTANCE.toDto(templatePort.updateTemplate(id, TemplateDtoMapper.INSTANCE.toCommand(templateDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable Long id) {
        templatePort.deleteTemplate(id);
    }
}
