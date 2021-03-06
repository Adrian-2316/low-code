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
    /**
     * Method to clone the template module into the new one and replace the directory name.
     *
     * @param name - The new name of the module.
     * @throws IOException - If the file cannot be read or written.
     */
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

    /**
     * Method to replace all files with the new module name.
     *
     * @param name - Name of the new module.
     * @throws IOException - If the file cannot be read or written.
     */
    public static void replaceFiles(String name) throws IOException {
        String currentDirectoryLocation = "../" + name;
        List<String> fileList = new ArrayList<>();
        fileList.add("/pom.xml");
        fileList.add("/src/main/resources/application.properties");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/" + StringUtils.toUpperCamelCase(name) + "Application.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/swagger/SwaggerConfigurerNotLocal.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/swagger/SwaggerController.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/validations/annotations/EnumValidator.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/validations/constraints/EnumConstraint.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/log/streams/BufferedServletInputStream.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/log/streams/TeeServletOutputStream.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/log/wrappers/BufferedRequestWrapper.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/log/wrappers/BufferedResponseWrapper.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/log/AsyncLogger.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/log/RequestFilter.java");
        fileList.add("/src/main/java/com/project/" + StringUtils.toLowerCamelCase(name) + "/log/RequestLogger.java");
        for (String file : fileList) {
            File fileToBeModified = new File(currentDirectoryLocation + file);
            FileUtil.replaceText(fileToBeModified, "module", name);
        }
    }

    /**
     * Replaces the folders in the module.
     * MUST BE CALLED AFTER THE MODULE HAS BEEN CLONED.
     * MUST BE ORDERED FROM OUTSIDE TO INSIDE.
     *
     * @param name Name of the module.
     */
    public static void replaceFolders(String name) {
        name = StringUtils.toLowerCamelCase(name);
        String upperCamelCaseName = StringUtils.toUpperCamelCase(name);
        LinkedHashMap<String, String> folderMap = new LinkedHashMap<>();
        folderMap.put("../" + name + "/src/main/java/com/project/module", "../" + name + "/src/main/java/com/project/" + name);
        folderMap.put("../" + name + "/src/main/java/com/project/" + name + "/ModuleApplication.java", "../" + name + "/src/main/java/com/project/" + name + "/" + upperCamelCaseName + "Application.java");
        for (Map.Entry<String, String> entry : folderMap.entrySet()) {
            File folderToBeModified = new File(entry.getKey());
            FileUtil.renameFolder(folderToBeModified, new File(entry.getValue()));
        }
    }
}
