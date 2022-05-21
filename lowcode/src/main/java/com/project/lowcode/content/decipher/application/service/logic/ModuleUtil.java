package com.project.lowcode.content.decipher.application.service.logic;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModuleUtil {

    public static void cloneModule(String name)
            throws IOException {
        String sourceDirectoryLocation = "../template";
        String destinationDirectoryLocation = "../" + name;

        File sourceDirectory = new File(sourceDirectoryLocation);
        File destinationDirectory = new File(destinationDirectoryLocation);
        FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
    }

    public static void replaceFiles(String name) {
        String currentDirectoryLocation = "../" + name;
        List<String> fileList = new ArrayList<>();
        fileList.add("/pom.xml");

        fileList.stream().map(file -> new File(currentDirectoryLocation + file)).forEach(fileToBeModified -> FileUtil.replaceText(name, fileToBeModified));
    }

}
