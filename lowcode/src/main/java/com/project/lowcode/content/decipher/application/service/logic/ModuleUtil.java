package com.project.lowcode.content.decipher.application.service.logic;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModuleUtil {

    public static void cloneModule(String name)
            throws IOException {
        String sourceDirectoryLocation = "../template";
        String destinationDirectoryLocation = "../" + name.substring(0, 1).toLowerCase() + name.substring(1);

        File sourceDirectory = new File(sourceDirectoryLocation);
        File destinationDirectory = new File(destinationDirectoryLocation);
        FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
    }

    public static void replaceFiles(String name) {
        String currentDirectoryLocation = "../" + name;
        List<String> fileList = new ArrayList<>();
        fileList.add("/pom.xml");
        fileList.add("/src/main/resources/application.properties");

        for (String file : fileList) {
            File fileToBeModified = new File(currentDirectoryLocation + file);
            FileUtil.replaceText(name, fileToBeModified);
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
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
        String upperCamelCaseName = name.substring(0, 1).toUpperCase() + name.substring(1);
        Map<String, String> folderMap = Map.of(
                "../" + name + "/src/main/java/com/project/template/TemplateApplication.java", "../" + name + "/src/main/java/com/project/template/" + upperCamelCaseName + "Application.java",
                "../" + name + "/src/main/java/com/project/template", "../" + name + "/src/main/java/com/project/" + name
        );
        for (Map.Entry<String, String> entry : folderMap.entrySet()) {
            File folderToBeModified = new File(entry.getKey());
            FileUtil.renameFolder(folderToBeModified, new File(entry.getValue()));
        }
    }
}
