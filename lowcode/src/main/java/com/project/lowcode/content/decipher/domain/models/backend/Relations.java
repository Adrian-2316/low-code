package com.project.lowcode.content.decipher.domain.models.backend;

import com.project.lowcode.shared.RelationType;
import com.project.lowcode.shared.StringUtils;
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
    private String referencedColumnName;
    private String table;
    private String columnDefinition;
    private String catalog;
    private String schema;
    private Boolean nullable;
    private Boolean optional;
    private Boolean insertable;
    private Boolean updatable;
    private Boolean orphanRemoval;
    private FetchType fetchType;
    private CascadeType cascadeType;
    private RelationType relationType;

    /**
     * @return RelationType - The inverse relation type of the current relation.
     */
    public RelationType getInverseRelationType() {
        return switch (relationType) {
            case OneToOne -> RelationType.OneToOne;
            case OneToMany -> RelationType.ManyToOne;
            case ManyToOne -> RelationType.OneToMany;
            case ManyToMany -> RelationType.ManyToMany;
        };
    }

    /**
     * @return tableName - The name of the target many-to-many table name which max length is 64.
     */
    public String getManyToManyTableName() {
        String tableName = "rel_" + StringUtils.toJPAName(firstEntity) + "_" + StringUtils.toJPAName(secondEntity);
        return tableName.substring(0, Math.min(tableName.length(), 64));
    }
}
