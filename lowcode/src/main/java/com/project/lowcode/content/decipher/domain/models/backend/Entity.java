package com.project.lowcode.content.decipher.domain.models.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    private String name;
    private List<Field> fields;
}
