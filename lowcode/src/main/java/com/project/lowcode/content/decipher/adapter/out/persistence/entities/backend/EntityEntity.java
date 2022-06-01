package com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntityEntity {
    @Column(name = "name", precision = 12, scale = 12, columnDefinition = "default 'string'", length = 0, nullable = true, unique = true)
    private String name;
    private List<FieldEntity> fields;
}
