package com.project.lowcode.content.decipher.application.service.logic;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ModuleUtil {

    public static void cloneModule(String name)
            throws IOException {
        String sourceDirectoryLocation = "../template";
        String destinationDirectoryLocation = "../" + name;

        File sourceDirectory = new File(sourceDirectoryLocation);
        File destinationDirectory = new File(destinationDirectoryLocation);
        FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
    }
}
