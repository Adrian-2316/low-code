package com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend;

import com.project.lowcode.shared.JpaRelations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelationsEntity {
    private String firstEntity;
    private String secondEntity;
    private Boolean isFirstOwner;
    private Boolean optional;
    private Boolean loading;
    private JpaRelations jpaRelations;
}
