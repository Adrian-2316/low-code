package com.project.lowcode.content.json.adapter.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonDto {
    private String id;
    private String type;
    private FieldDto[] fields;
}
