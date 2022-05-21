package com.project.lowcode.content.decipher.application.service.logic;

import java.io.*;
import java.util.Objects;

public class FileUtil {
    public static void replaceText(String newString, File fileToBeModified) {
        StringBuilder oldContent = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            String newContent = oldContent.toString().replaceAll("template", newString.substring(0, 1).toLowerCase() + newString.substring(1));
            String finalContent = newContent.replaceAll("Template", newString.substring(0, 1).toUpperCase() + newString.substring(1));

            writer = new FileWriter(fileToBeModified);

            writer.write(finalContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(reader).close();
                Objects.requireNonNull(writer).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void renameFolder(File file, File newFile) {
        if (file.exists())
            file.renameTo(newFile);
    }
}
