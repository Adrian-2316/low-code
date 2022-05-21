package com.project.lowcode.content.json.application.ports.in.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonCommand {
    private String id;
    private String type;
    private FieldCommand[] fields;
}
