package com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend;

import com.project.lowcode.shared.RelationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelationsEntity {
    private String firstEntity;
    private String secondEntity;
    private String targetEntity;
    private Boolean optional;
    private Boolean loading;
    private Boolean insertable;
    private Boolean updatable;
    private FetchType fetchType;
    private CascadeType cascadeType;
    private RelationType relationType;
}
