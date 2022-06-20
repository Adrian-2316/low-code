package com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityEntity {
    private String name;
    private List<FieldEntity> fields;
}
