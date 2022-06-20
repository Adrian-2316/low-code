package com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend;

import com.project.lowcode.shared.RelationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationsEntity {
    private String firstEntity;
    private String secondEntity;
    private String targetEntity;
    private String referencedColumnName;
    private String columnDefinition;
    private String catalog;
    private String schema;
    private String table;
    private Boolean nullable;
    private Boolean optional;
    private Boolean insertable;
    private Boolean updatable;
    private Boolean orphanRemoval;
    private FetchType fetchType;
    private CascadeType cascadeType;
    private RelationType relationType;
}
