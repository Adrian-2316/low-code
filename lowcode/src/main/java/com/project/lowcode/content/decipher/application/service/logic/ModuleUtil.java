package com.project.lowcode.content.decipher.application.service.logic;

import com.project.lowcode.shared.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModuleUtil {
    public static void cloneModule(String name)
            throws IOException {
        String sourceDirectoryLocation = "../module";
        String destinationDirectoryLocation = "../" + StringUtils.toLowerCamelCase(name);
        File sourceDirectory = new File(sourceDirectoryLocation);
        File destinationDirectory = new File(destinationDirectoryLocation);
        if (sourceDirectory.exists() && !destinationDirectory.exists()) {
            FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
        }
    }

    public static void replaceFiles(String name) throws IOException {
        String currentDirectoryLocation = "../" + name;
        List<String> fileList = new ArrayList<>();
        fileList.add("/pom.xml");
        fileList.add("/src/main/resources/application.properties");

        for (String file : fileList) {
            File fileToBeModified = new File(currentDirectoryLocation + file);
            FileUtil.replaceText(name, fileToBeModified, "module");
        }
    }

    /**
     * Replaces the folders in the module.
     * MUST BE CALLED AFTER THE MODULE HAS BEEN CLONED.
     * MUST BE ORDERED FROM OUTSIDE TO INSIDE.
     *
     * @param name the name of the module
     */
    public static void replaceFolders(String name) {
        name = StringUtils.toLowerCamelCase(name);
        String upperCamelCaseName = StringUtils.toUpperCamelCase(name);
        LinkedHashMap<String, String> folderMap = new LinkedHashMap<>();
        folderMap.put("../" + name + "/src/main/java/com/project/module", "../" + name + "/src/main/java/com/project/" + name);
        folderMap.put("../" + name + "/src/main/java/com/project/" + name + "/TemplateApplication.java", "../" + name + "/src/main/java/com/project/" + name + "/" + upperCamelCaseName + "Application.java");
        for (Map.Entry<String, String> entry : folderMap.entrySet()) {
            File folderToBeModified = new File(entry.getKey());
            FileUtil.renameFolder(folderToBeModified, new File(entry.getValue()));
        }
    }
}
