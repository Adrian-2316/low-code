package com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntityDto {
    private String name;
    private List<FieldDto> fields;
}
