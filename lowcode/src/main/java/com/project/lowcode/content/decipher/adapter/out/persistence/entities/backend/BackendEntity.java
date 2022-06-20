package com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackendEntity {
    private String name;
    private List<EntityEntity> entity;
    private List<RelationsEntity> relations;
}
