package com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend;

import com.project.lowcode.shared.RelationType;
import com.project.lowcode.validations.annotations.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationsDto {

    private String firstEntity;
    private String secondEntity;
    private String targetEntity;
    private String referencedColumnName;
    private String columnDefinition;
    private String catalog;
    private String schema;
    private String table;
    private Boolean nullable = true;
    private Boolean optional = false;
    private Boolean insertable = true;
    private Boolean updatable = true;
    private Boolean orphanRemoval = false;
    @EnumValidator(
            enumClazz = FetchType.class,
            message = "Invalid value found for FetchType")
    private FetchType fetchType;
    @EnumValidator(
            enumClazz = CascadeType.class,
            message = "Invalid value found for CascadeType")
    private CascadeType cascadeType;
    @EnumValidator(
            enumClazz = RelationType.class,
            message = "Invalid value found in jpa relations")
    private RelationType relationType;
}
