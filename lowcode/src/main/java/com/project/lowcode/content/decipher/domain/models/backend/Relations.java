package com.project.lowcode.content.decipher.domain.models.backend;

import com.project.lowcode.shared.JpaRelations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relations {
    private String firstEntity;
    private String secondEntity;
    private Boolean isFirstOwner;
    private Boolean optional;
    private Boolean loading;
    private JpaRelations jpaRelations;
}
