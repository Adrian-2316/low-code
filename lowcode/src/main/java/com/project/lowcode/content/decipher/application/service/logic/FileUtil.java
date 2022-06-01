package com.project.lowcode.content.decipher.application.service.logic;

import com.project.lowcode.content.decipher.domain.models.backend.Entity;
import com.project.lowcode.content.decipher.domain.models.backend.Field;
import com.project.lowcode.content.decipher.domain.models.backend.Relations;
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
    public static void replaceText(String newString, File fileToBeModified) throws IOException {
        String data = FileUtils.readFileToString(fileToBeModified, "UTF-8");
        data = data.replace("template", StringUtils.toLowerCamelCase(newString));
        data = data.replace("Template", StringUtils.toUpperCamelCase(newString));
        FileWriter writer = new FileWriter(fileToBeModified);
        writer.write(data);
        Objects.requireNonNull(writer).close();
    }

    public static void addConstructorFields(Entity entity, List<Relations> relations, List<File> files) throws IOException, IllegalAccessException {
        for (File file : files) {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            if (!lines.contains("    //Insert your code here")) return;
            addFields(entity, file, lines, lines.indexOf("    //Insert your code here"));
            FileUtils.writeLines(file, "UTF-8", lines);
        }
    }

    private static void addFields(Entity entity, File file, List<String> lines, int index) throws IllegalAccessException {
        for (Field field : entity.getFields()) {
            if (entity.getName().equalsIgnoreCase(file.getName().replace("Entity.java", ""))) {
                lines.add(index++, buildColumn(field));
            }
            lines.add(index++, String.format("\tprivate %s %s;", field.getType(), field.getName()));
            lines.add(index++, System.lineSeparator());
        }
    }

    private static String buildColumn(Field field) throws IllegalAccessException {
        String column = "\t@Column(%s %s %s %s %s %s %s)";
        List<String> availableProperties = new ArrayList<>();
        java.lang.reflect.Field[] fields = field.getClass().getDeclaredFields();
        for (java.lang.reflect.Field aux : fields) {
            if (aux.getName().equals("autoIncrement")) continue;
            aux.setAccessible(true);
            if (!aux.getName().equals("defaultValue")) {
                String value = aux.getName().equals("name") ? "\"" + aux.get(field) + "\"" : aux.get(field).toString();
                availableProperties.add(aux.get(field) != null ? String.format("%s = %s ,", aux.getName(), value) : "");
                continue;
            }
            availableProperties.add(aux.get(field) != null ? String.format("columnDefinition = \"default '%s'\" ,", aux.get(field)) : "");
        }
        return replaceColumn(column, availableProperties);
    }

    private static String replaceColumn(String replaceText, List<String> valuesList) {
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

    public static void addRelations(Entity entity, List<Relations> relations, List<File> files) throws IOException {


    }

    private static void writeRelation(Relations relation, StringBuilder oldContent) {
        String fetchType = "";
        String cascadeType = "";
    }

}
