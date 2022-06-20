package com.project.lowcode.content.decipher.domain.models.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Backend {
    private String name;
    private List<Entity> entity;
    private List<Relations> relations;
}
