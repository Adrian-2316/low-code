package com.project.lowcode.content.decipher.application.service.logic;

import com.project.lowcode.content.decipher.domain.models.Decipher;
import com.project.lowcode.content.decipher.domain.models.backend.Entity;
import com.project.lowcode.content.decipher.domain.models.backend.Field;
import com.project.lowcode.content.decipher.domain.models.backend.Relations;
import com.project.lowcode.shared.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FileUtil {
    public static String GENERATION_CODE_SEGMENT_START = "    // Generation code segment start";
    public static String GENERATION_CODE_SEGMENT_END = "    // Generation code segment end";
    public static String GENERATION_IMPORT_CODE_START = "// Generation import code segment start";
    public static String GENERATION_IMPORT_CODE_END = "// Generation import code segment end";

    /**
     * Replaces the template text in the provided file with the input String.
     *
     * @param newString        - The new string to replace.
     * @param fileToBeModified - The file to be modified.
     * @param oldString        - The old string to be replaced.
     * @throws IOException - If the file cannot be read or written.
     */
    public static void replaceText(File fileToBeModified, String oldString, String newString) throws IOException {
        String data = FileUtils.readFileToString(fileToBeModified, "UTF-8");
        data = data.replace(oldString.toLowerCase(), StringUtils.toLowerCamelCase(newString));
        data = data.replace(StringUtils.toUpperCamelCase(oldString), StringUtils.toUpperCamelCase(newString));
        FileWriter writer = new FileWriter(fileToBeModified);
        writer.write(data);
        Objects.requireNonNull(writer).close();
    }

    /**
     * Method to clean all fields in classes.
     *
     * @param files - List of files to be modified.
     * @throws IOException - If the file cannot be read or written.
     */
    public static void removeClassLines(List<File> files) throws IOException {
        for (File file : files) {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            if (lines.contains(GENERATION_IMPORT_CODE_START)) {
                int start = lines.indexOf(GENERATION_IMPORT_CODE_START) + 1;
                int end = lines.indexOf(GENERATION_IMPORT_CODE_END);
                lines.subList(start, end).clear();
            }
            if (lines.contains(GENERATION_CODE_SEGMENT_START)) {
                int start = lines.indexOf(GENERATION_CODE_SEGMENT_START) + 1;
                int end = lines.indexOf(GENERATION_CODE_SEGMENT_END);
                lines.subList(start, end).clear();
            }
            FileUtils.writeLines(file, "UTF-8", lines);
        }
    }

    /**
     * Method to add all fields in classes.
     *
     * @param files    - List of files to be modified.
     * @param entity   - Entity.
     * @param decipher - Decipher entity.
     * @throws IOException - If the file cannot be read or written..
     */
    public static void addClassLines(Entity entity, Decipher decipher, List<File> files) throws IOException {
        for (File file : files) {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            if (!lines.contains(GENERATION_CODE_SEGMENT_START) || !lines.contains(GENERATION_IMPORT_CODE_START))
                continue;

            addImports(entity, decipher, file, lines, lines.indexOf(GENERATION_IMPORT_CODE_START) + 1);
            addFields(entity, file, lines, lines.indexOf(GENERATION_CODE_SEGMENT_START) + 1);
            addRelations(entity, decipher.getBackend().getRelations(), file, lines, lines.indexOf(GENERATION_CODE_SEGMENT_START) + 1);

            FileUtils.writeLines(file, "UTF-8", lines);
        }
    }

    private static void addImports(Entity entity, Decipher decipher, File file, List<String> lines, int index) {
        lines.add(index++, BuilderUtil.buildFieldImports(entity.getFields()));
        for (Relations relation : decipher.getBackend().getRelations()) {
            lines.add(index++, BuilderUtil.buildRelationImports(relation, decipher, file, entity));
        }
    }

    /**
     * Method to add all fields in classes.
     *
     * @param entity - Target entity
     * @param file   - Target file
     * @param lines  - List of lines
     * @param index  - Index
     */
    private static void addFields(Entity entity, File file, List<String> lines, int index) {
        for (Field field : entity.getFields()) {
            if (file.getName().endsWith("Entity.java")) {
                lines.add(index++, BuilderUtil.buildJpaColumn(field));
                lines.add(index++, BuilderUtil.buildField(field.getType().toString(), field.getName(), ""));
            } else if (file.getName().endsWith("Dto.java")) {
                lines.add(index++, BuilderUtil.buildField(field.getType().toString(), field.getName(), ""));
            } else {
                lines.add(index++, BuilderUtil.buildField(field.getType().toString(), field.getName(), ""));
            }
        }
    }

    /**
     * Method used to rename a folder.
     *
     * @param file    - File to be renamed
     * @param newFile - New file renamed
     */
    public static void renameFolder(File file, File newFile) {
        if (file.exists()) {
            boolean b = file.renameTo(newFile);

        }
    }

    /**
     * Method to write all relations in a file.
     *
     * @param file      - File to be modified.
     * @param relations - List of relations.
     * @param index     - Line index.
     * @param lines     - List of lines.
     * @param entity    - Entity class.
     */
    public static void addRelations(Entity entity, List<Relations> relations, File file, List<String> lines, int index) {
        for (Relations relation : relations) {
            if (relation.getFirstEntity().equals(entity.getName()))
                index = addRelation(file, lines, index, relation, true, relation.getSecondEntity());
            if (relation.getSecondEntity().equals(entity.getName()))
                index = addRelation(file, lines, index, relation, false, relation.getFirstEntity());
        }
    }

    /**
     * Method to write a relation in a file.
     *
     * @param file        - File to be modified.
     * @param lines       - List of lines to be added.
     * @param index       - Line index.
     * @param relation    - Relation to be built.
     * @param isOwnerSide - If the relation is owner side.
     * @param fieldEntity - Entity name.
     * @return - Index of the next line.
     */
    private static int addRelation(File file, List<String> lines, int index, Relations relation, boolean isOwnerSide, String fieldEntity) {
        String relationType = BuilderUtil.buildRelationType(relation, fieldEntity);
        if (file.getName().endsWith("Entity.java")) {
            lines.add(index++, BuilderUtil.buildJpaRelation(relation, isOwnerSide));
            if (isOwnerSide) lines.add(index++, BuilderUtil.buildJpaJoin(relation));
            lines.add(index++, BuilderUtil.buildField(relationType, StringUtils.toLowerCamelCase(fieldEntity), "Entity"));
        } else if (file.getName().endsWith("Dto.java")) {
            lines.add(index++, BuilderUtil.buildField(relationType, StringUtils.toLowerCamelCase(fieldEntity), "Dto"));
        } else {
            lines.add(index++, BuilderUtil.buildField(relationType, StringUtils.toLowerCamelCase(fieldEntity), ""));
        }
        return index;
    }
}
