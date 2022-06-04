package com.project.lowcode.content.decipher.application.service.logic;

import com.project.lowcode.content.decipher.domain.models.backend.Field;
import com.project.lowcode.content.decipher.domain.models.backend.Relations;
import com.project.lowcode.shared.RelationType;
import com.project.lowcode.shared.StringUtils;

public class BuilderUtil {

    /**
     * Method used to build relation types.
     *
     * @param relation - Relation to be build.
     * @return String - String to be added as a relation type (e.g. Set<Entity>, Entity...)
     */
    public static String buildRelationType(Relations relation, String fieldEntity) {
        String relationType = StringUtils.toUpperCamelCase(fieldEntity);
        if (relation.getRelationType().equals(RelationType.ManyToOne) || relation.getRelationType().equals(RelationType.ManyToMany)) {
            relationType += "Set<" + StringUtils.toUpperCamelCase(fieldEntity) + ">";
        }
        return relationType;
    }

    /**
     * Method used to build class fields.
     *
     * @param type      - Type of the field.
     * @param name      - Name of the field.
     * @param extension - Extension of the field.
     * @return String - String to be added as a field (e.g. private String name;)
     */
    public static String buildField(String type, String name, String extension) {
        return String.format("\tprivate %s %s;", type + extension, name);
    }

    /**
     * Method to build JPA entity '@Column(...)'
     *
     * @param field - Field used to build the column parameters
     * @return String - JPA entity '@Column(...)'
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/Column.html">Column</a>
     */
    public static String buildJpaColumn(Field field) {
        String jpaColumn = "\t@Column(%s%s%s%s%s%s%s%s%s%s)";
        String name = field.getName() != null ? "name = \"" + field.getName() + "\"" : "";
        String columnDefinition = field.getColumnDefinition() != null ? field.getColumnDefinition() : "";
        String insertable = field.getInsertable() ? "" : ", insertable = false";
        String updatable = field.getUpdatable() ? "" : ", updatable = false";
        String nullable = field.getNullable() ? "" : ", nullable = false";
        String unique = field.getUnique() ? ", unique = true" : "";
        String length = field.getLength() != null ? ", length = " + field.getLength() : "";
        String precision = field.getPrecision() != null ? ", precision = " + field.getPrecision() : "";
        String scale = field.getScale() != null ? ", scale = " + field.getScale() : "";
        String table = field.getTable() != null ? ", table = \"" + field.getTable() + "\"" : "";
        return String.format(jpaColumn, name, columnDefinition, insertable, updatable, nullable, unique, length, precision, scale, table);
    }

    /**
     * Method used to build JPA relationships '@OneToOne(...)', '@ManyToMany(...)', ...
     *
     * @param relation    - Relation to be build.
     * @param isOwnerSide - True if the relation is the owner side.
     * @return String - String to be added as a JPA relation (e.g. @OneToMany(mappedBy = "owner")
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/OneToOne.html">OneToOne</a>
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/ManyToOne.html">ManyToOne</a>
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/ManyToMany.html">ManyToMany</a>
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/OneToMany.html">OneToMany</a>
     */
    public static String buildJpaRelation(Relations relation, Boolean isOwnerSide) {
        String relationBuilderTemplate = "\t@%r(%s%s%s%s%s)";
        String relationBuilder = isOwnerSide ? relationBuilderTemplate.replace("%r", relation.getRelationType().toString()) : relationBuilderTemplate.replace("%r", relation.getInverseRelationType().toString());
        String mappedBy = !isOwnerSide ? "mappedBy = \"" + StringUtils.toLowerCamelCase(relation.getSecondEntity()) + "\"" : "";
        String fetchType = relation.getFetchType() != null ? ", fetch = FetchType." + relation.getFetchType().toString() : "";
        String cascadeType = relation.getCascadeType() != null ? ", cascade = CascadeType." + relation.getCascadeType().toString() : "";
        String orphanRemoval = relation.getOrphanRemoval() ? ", orphanRemoval = true" : "";
        String optional = !relation.getOptional() ? ", optional = false" : "";
        return switch (relation.getRelationType()) {
            case OneToOne ->
                    StringUtils.removeBadFormattingChars(String.format(relationBuilder, mappedBy, fetchType, cascadeType, orphanRemoval, optional));
            case OneToMany ->
                    StringUtils.removeBadFormattingChars(String.format(relationBuilder, mappedBy, fetchType, cascadeType, orphanRemoval, ""));
            case ManyToOne ->
                    StringUtils.removeBadFormattingChars(String.format(relationBuilder, fetchType, cascadeType, optional, "", ""));
            case ManyToMany ->
                    StringUtils.removeBadFormattingChars(String.format(relationBuilder, fetchType, cascadeType, mappedBy, "", ""));
        };

    }

    /**
     * @param relation - Relation to be build.
     * @return (String) joinColumn - It returns the JoinColumn text annotation for the relation.
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/JoinColumn.html">JoinColumn</a>
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/JoinTable.html">JoinTable</a>
     */
    public static String buildJpaJoin(Relations relation) {
        if (relation.getRelationType().equals(RelationType.ManyToMany)) {
            String joinTable = "\t@JoinTable(%s%s%s%s%s)";
            String name = "\n\tname = \"" + relation.getManyToManyTableName();
            String catalog = relation.getCatalog() != null ? ",\n\tcatalog = \"" + relation.getCatalog() + "\"" : "";
            String schema = relation.getSchema() != null ? ",\n\tschema = \"" + relation.getSchema() + "\"" : "";
            String joinColumns = ",\n\tjoinColumns = {@JoinColumn(name = \"id\")}";
            String inverseJoinColumns = ",\n\tinverseJoinColumns = {@JoinColumn(name = \"id\")}";
            return String.format(joinTable, name, catalog, schema, joinColumns, inverseJoinColumns);
        }
        String joinColumn = "\t@JoinColumn(%s%s%s%s%s%s%s)";
        String name = "name = \"" + StringUtils.toJPAName(relation.getSecondEntity()) + "\"";
        String insertable = relation.getInsertable() ? "" : ",insertable = false";
        String updatable = relation.getUpdatable() ? "" : ",updatable = false";
        String table = relation.getTable() != null ? ",table = \"" + relation.getTable() + "\"" : "";
        String columnDefinition = relation.getColumnDefinition() != null ? ",columnDefinition = \"" + relation.getColumnDefinition() + "\"" : "";
        String nullable = relation.getNullable() ? "" : ",nullable = false";
        String referencedColumnName = relation.getReferencedColumnName() != null ? ",referencedColumnName = \"" + relation.getReferencedColumnName() + "\"" : "";
        return String.format(joinColumn, name, referencedColumnName, columnDefinition, insertable, updatable, table, nullable);
    }
}
