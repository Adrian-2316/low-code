package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityDto {
    private String name;
    private List<FieldDto> fields;
}
