package com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend;

import com.project.lowcode.shared.JpaRelations;
import com.project.lowcode.validations.annotations.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelationsDto {
    private String firstEntity;
    private String secondEntity;
    private Boolean isFirstOwner;
    private Boolean optional;
    private Boolean loading;
    @EnumValidator(
            enumClazz = JpaRelations.class,
            message = "Invalid value found in jpa relations")
    private JpaRelations jpaRelations;
}
