package com.project.lowcode.content.decipher.domain.models.backend;

import com.project.lowcode.shared.RelationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relations {
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
