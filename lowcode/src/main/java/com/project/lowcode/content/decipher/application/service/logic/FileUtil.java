package com.project.lowcode.content.decipher.application.service.logic;

import com.project.lowcode.content.decipher.domain.models.Entity;
import com.project.lowcode.content.decipher.domain.models.Field;
import com.project.lowcode.shared.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class FileUtil {
    public static void replaceText(String newString, File fileToBeModified) throws IOException {
        StringBuilder oldContent = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
        String line = reader.readLine();
        while (line != null) {
            oldContent.append(line).append(System.lineSeparator());
            line = reader.readLine();
        }
        String newContent = oldContent.toString().replaceAll("template", StringUtils.toLowerCamelCase(newString));
        String finalContent = newContent.replaceAll("Template", StringUtils.toUpperCamelCase(newString));
        FileWriter writer = new FileWriter(fileToBeModified);
        writer.write(finalContent);
        Objects.requireNonNull(reader).close();
        Objects.requireNonNull(writer).close();
    }

    public static void addConstructorFields(Entity entity, List<File> files) throws IOException {
        for (File file : files) {
            StringBuilder oldContent = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());
                addFields(entity, oldContent, line, file);
                line = reader.readLine();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(oldContent.toString());
            Objects.requireNonNull(reader).close();
            Objects.requireNonNull(writer).close();
        }
    }

    private static void addFields(Entity entity, StringBuilder oldContent, String line, File file) {
        if (line.contains("public class")) {
            oldContent.append(System.lineSeparator());
            for (Field field : entity.getFields()) {
                if (entity.getName().equalsIgnoreCase(file.getName().replace("Entity.java", ""))) {
                    oldContent.append("\t@Column(name = \"").append(field.getName()).append("\"");
                    if (field.getLength() != null) oldContent.append(" , length = ").append(field.getLength());
                    oldContent.append(")").append(System.lineSeparator());
                }
                oldContent.append("\tprivate ").append(field.getType()).append(" ").append(field.getName()).append(";").append(System.lineSeparator());
            }
        }
    }

    public static void renameFolder(File file, File newFile) {
        if (file.exists())
            file.renameTo(newFile);
    }
}
