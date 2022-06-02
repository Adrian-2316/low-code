package com.project.lowcode.content.decipher.application.service.logic;

import com.project.lowcode.content.decipher.domain.models.backend.Entity;
import com.project.lowcode.content.decipher.domain.models.backend.Field;
import com.project.lowcode.content.decipher.domain.models.backend.Relations;
import com.project.lowcode.shared.RelationType;
import com.project.lowcode.shared.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class FileUtil {
    public static String GENERATION_CODE_SEGMENT_START = "\t// Generation code segment start";
    public static String GENERATION_CODE_SEGMENT_END = "\t// Generation code segment end";

    public static void replaceText(String newString, File fileToBeModified) throws IOException {
        String data = FileUtils.readFileToString(fileToBeModified, "UTF-8");
        data = data.replace("template", StringUtils.toLowerCamelCase(newString));
        data = data.replace("Template", StringUtils.toUpperCamelCase(newString));
        FileWriter writer = new FileWriter(fileToBeModified);
        writer.write(data);
        Objects.requireNonNull(writer).close();
    }

    /**
     * Method to remove the unwanted constructor fields to input files
     *
     * @param files - List of files to be modified
     * @throws IOException - IOException
     */
    public static void removeConstructorLines(List<File> files) throws IOException {
        for (File file : files) {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            if (lines.contains(GENERATION_CODE_SEGMENT_START)) {
                int start = lines.indexOf(GENERATION_CODE_SEGMENT_START) + 1;
                int end = lines.indexOf(GENERATION_CODE_SEGMENT_END);
                lines.subList(start, end).clear();
            }
            FileUtils.writeLines(file, "UTF-8", lines);
        }
    }

    /**
     * Method to add wanted constructor fields to input files
     *
     * @param files     - List of files to be modified
     * @param entity    - Entity
     * @param relations - Relations
     * @throws IOException - IOException
     */
    public static void addConstructorLines(Entity entity, List<Relations> relations, List<File> files) throws IOException, IllegalAccessException {
        for (File file : files) {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            if (!lines.contains(GENERATION_CODE_SEGMENT_START)) return;
            // Add fields to constructor
            addFields(entity, file, lines, lines.indexOf(GENERATION_CODE_SEGMENT_START) + 1);
            // Add relations to constructor
            addRelations(entity, relations, file, lines, lines.indexOf(GENERATION_CODE_SEGMENT_START) + 1);
            FileUtils.writeLines(file, "UTF-8", lines);
        }
    }

    private static void addFields(Entity entity, File file, List<String> lines, int index) throws IllegalAccessException {
        for (Field field : entity.getFields()) {
            // Persistence JPA entity '@Column(...)'
            if (entity.getName().equalsIgnoreCase(file.getName().replace("Entity.java", ""))) {
                lines.add(index++, buildJpaColumn(field));
            }
            // Field declaration
            index = writeFieldDeclaration(lines, index, field.getType().toString(), field.getName());
        }
    }

    private static int writeFieldDeclaration(List<String> lines, int index, String field, String name) {
        lines.add(index++, String.format("\tprivate %s %s;", field, name));
        lines.add(index++, System.lineSeparator());
        return index;
    }

    /**
     * Method to build JPA entity '@Column(...)'
     *
     * @param field - Field used to build the column parameters
     * @throws IllegalAccessException - IllegalAccessException
     */
    private static String buildJpaColumn(Field field) throws IllegalAccessException {
        String column = "\t@Column(%s %s %s %s %s %s %s)";
        List<String> availableProperties = new ArrayList<>();
        java.lang.reflect.Field[] fields = field.getClass().getDeclaredFields();
        for (java.lang.reflect.Field aux : fields) {
            aux.setAccessible(true);
            if (aux.get(field) == null) continue;
            if (aux.getName().equals("autoIncrement")) continue;
            if (!aux.getName().equals("defaultValue")) {
                String value = aux.getName().equals("name") ? "\"" + aux.get(field) + "\"" : aux.get(field).toString();
                availableProperties.add(aux.get(field) != null ? String.format("%s = %s ,", aux.getName(), value) : "");
                continue;
            }
            availableProperties.add(aux.get(field) != null ? String.format("columnDefinition = \"default '%s'\" ,", aux.get(field)) : "");
        }
        return replaceColumnProperties(column, availableProperties);
    }

    /**
     * Method to replace the column parameters
     *
     * @param replaceText - String to be replaced
     * @param valuesList  - List of values to be replaced
     * @return - Replaced column properties
     */
    private static String replaceColumnProperties(String replaceText, List<String> valuesList) {
        Pattern patter = Pattern.compile("%s");
        while (patter.matcher(replaceText).find()) {
            replaceText = replaceText.replaceFirst("%s", valuesList.remove(0));
        }
        return new StringBuilder(replaceText).deleteCharAt(replaceText.length() - 2).toString();
    }


    public static void renameFolder(File file, File newFile) {
        if (file.exists()) {
            boolean b = file.renameTo(newFile);
        }
    }

    public static void addRelations(Entity entity, List<Relations> relations, File file, List<String> lines, int index) throws IOException {
        for (Relations relation : relations) {
            if (!relation.getFirstEntity().equals(entity.getName()) && !relation.getSecondEntity().equals(entity.getName()))
                continue;
            if (relation.getFirstEntity().equals(entity.getName())) {
                // Persistence JPA relation
                index = buildRelation(entity, file, lines, index, relation);
                String relationType = buildRelationType(relation);
                index = writeFieldDeclaration(lines, index, relationType, StringUtils.toLowerCamelCase(relation.getFirstEntity()));
            } else {
                if (entity.getName().equalsIgnoreCase(file.getName().replace("Entity.java", ""))) {
                    if (relation.getFirstEntity().equals(entity.getName())) {
                        lines.add(index++, buildJpaRelation(relation, entity));
                    }
                }
                index = writeFieldDeclaration(lines, index, relation.getSecondEntity(), relation.getSecondEntity());

            }
        }
    }

    private static String buildRelationType(Relations relation) {
        String relationType = StringUtils.toUpperCamelCase(relation.getFirstEntity());
        if (relation.getRelationType().equals(RelationType.ManyToOne) || relation.getRelationType().equals(RelationType.ManyToMany)) {
            relationType += "Set<" + StringUtils.toUpperCamelCase(relation.getSecondEntity()) + ">";
        }
        return relationType;
    }

    private static int buildRelation(Entity entity, File file, List<String> lines, int index, Relations relation) {
        if (entity.getName().equalsIgnoreCase(file.getName().replace("Entity.java", ""))) {
            lines.add(index++, buildJpaRelation(relation, entity));
        }
        return index;
    }

    private static String buildJpaRelation(Relations relation, Entity entity) {
        boolean isOwnerSide = !relation.getFirstEntity().equals(entity.getName());
        String templateBuilder = "\t@%r( %s %s %s %s %s %s %s )";
        String relationBuilder = templateBuilder.replace("%r", relation.getRelationType().toString());
        if (isOwnerSide) relationBuilder += "\n(%s %s %s %s %s %s %s)";
        String relationDefinition;
        if (!isOwnerSide) {
            relationDefinition = "mappedBy = \"" + StringUtils.toLowerCamelCase(relation.getSecondEntity()) + "\"";
            relationBuilder = String.format(relationDefinition, "", "", "", "", "", "");
        } else {
            relationDefinition = "@JoinColumn(name = \"id\")";
            String insertable = relation.getInsertable() ? "" : "insertable = false";
            String updatable = relation.getUpdatable() ? "" : "updatable = false";
            String fetchType = relation.getFetchType() != null ? "fetch = FetchType." + relation.getFetchType().toString() : "";
            String cascadeType = relation.getCascadeType() != null ? "cascade = CascadeType." + relation.getCascadeType().toString() : "";
            String loading = relation.getLoading() != null ? "load = " + relation.getLoading().toString() : "";
            String optional = relation.getOptional() ? "optional = true" : "";
            relationBuilder = String.format(relationDefinition, insertable, updatable, fetchType, cascadeType, loading, optional);
        }

        return relationBuilder;
    }

}
