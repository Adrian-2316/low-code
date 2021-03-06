package com.project.lowcode.content.decipher.application.service.logic;

import com.project.lowcode.content.decipher.domain.models.Decipher;
import com.project.lowcode.content.decipher.domain.models.backend.Entity;
import com.project.lowcode.shared.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EntityUtil {
    /**
     * Method used to replace all files names with the specified one.
     *
     * @param module - Module to be modified.
     * @param name   - New name of the module.
     * @throws IOException - If the file cannot be read or written.
     */
    public static void replaceFiles(String module, String name) throws IOException {
        name = StringUtils.toUpperCamelCase(name);
        String currentDirectoryLocation = "../" + module + "/src/main/java/com/project/" + module + "/content/" + StringUtils.toLowerCamelCase(name);
        List<String> fileList = new ArrayList<>();

        // Adapter
        String routePath = "/adapter/in/rest/";
        fileList.add(routePath + "dtos/" + name + "Dto.java");
        fileList.add(routePath + "dtos/" + name + "DtoMapper.java");
        fileList.add(routePath + name + "Controller.java");
        routePath = "/adapter/out/persistence/";
        fileList.add(routePath + name + "JpaRepository.java");
        fileList.add(routePath + name + "Repository.java");
        fileList.add(routePath + "entity/" + name + "Entity.java");
        fileList.add(routePath + "entity/" + name + "EntityMapper.java");

        // Application
        routePath = "/application/service/";
        fileList.add(routePath + name + "Service.java");
        fileList.add(routePath + "ports/in/" + name + "Port.java");
        fileList.add(routePath + "ports/out/" + name + "RepositoryPort.java");

        // Domain
        routePath = "/domain/models/";
        fileList.add(routePath + name + ".java");

        for (String file : fileList) {
            File fileToBeModified = new File(currentDirectoryLocation + file);
            FileUtil.replaceText(fileToBeModified, "template", StringUtils.toLowerCamelCase(name));
            FileUtil.replaceText(fileToBeModified, "module", StringUtils.toLowerCamelCase(module));
        }
    }

    /**
     * Replaces the folders in the module.
     * MUST BE CALLED AFTER THE MODULE HAS BEEN CLONED.
     * MUST BE ORDERED FROM OUTSIDE TO INSIDE.
     *
     * @param name   the name of the entity.
     * @param module the name of the module.
     */
    public static void replaceFolders(String module, String name) {
        module = StringUtils.toLowerCamelCase(module);
        name = StringUtils.toLowerCamelCase(name);
        String upperName = StringUtils.toUpperCamelCase(name);
        LinkedHashMap<String, String> folderMap = new LinkedHashMap<>();
        String entityPath = "../" + module + "/src/main/java/com/project/" + module + "/content/" + name;

        // Adapter in
        String routePath = "/adapter/in/rest/";
        folderMap.put(entityPath + routePath + "dtos/TemplateDto.java", entityPath + routePath + "dtos/" + upperName + "Dto.java");
        folderMap.put(entityPath + routePath + "dtos/TemplateDtoMapper.java", entityPath + routePath + "dtos/" + upperName + "DtoMapper.java");
        folderMap.put(entityPath + routePath + "TemplateController.java", entityPath + routePath + upperName + "Controller.java");

        // Adapter out
        routePath = "/adapter/out/persistence/";
        folderMap.put(entityPath + routePath + "TemplateJpaRepository.java", entityPath + routePath + upperName + "JpaRepository.java");
        folderMap.put(entityPath + routePath + "TemplateRepository.java", entityPath + routePath + upperName + "Repository.java");
        folderMap.put(entityPath + routePath + "entity/TemplateEntity.java", entityPath + routePath + "entity/" + upperName + "Entity.java");
        folderMap.put(entityPath + routePath + "entity/TemplateEntityMapper.java", entityPath + routePath + "entity/" + upperName + "EntityMapper.java");

        // Application
        routePath = "/application/service/";
        folderMap.put(entityPath + routePath + "TemplateService.java", entityPath + routePath + upperName + "Service.java");
        folderMap.put(entityPath + routePath + "ports/in/TemplatePort.java", entityPath + routePath + "ports/in/" + upperName + "Port.java");
        folderMap.put(entityPath + routePath + "ports/out/TemplateRepositoryPort.java", entityPath + routePath + "ports/out/" + upperName + "RepositoryPort.java");

        // Domain
        routePath = "/domain/models/";
        folderMap.put(entityPath + routePath + "/Template.java", entityPath + routePath + upperName + ".java");

        for (Map.Entry<String, String> entry : folderMap.entrySet()) {
            File folderToBeModified = new File(entry.getKey());
            FileUtil.renameFolder(folderToBeModified, new File(entry.getValue()));
        }
    }


    /**
     * Method used to clone the template folder inside content and replace its name with the new one.
     *
     * @param module - Module to be modified.
     * @param name   - New name of the module.
     * @throws IOException - If the file cannot be read or written.
     */
    public static void cloneContent(String module, String name) throws IOException {
        module = StringUtils.toLowerCamelCase(module);
        String sourceDirectoryLocation = "../" + module + "/src/main/java/com/project/" + module + "/content/template";
        String destinationDirectoryLocation = "../" + module + "/src/main/java/com/project/" + module + "/content/" + StringUtils.toLowerCamelCase(name);
        File sourceDirectory = new File(sourceDirectoryLocation);
        File destinationDirectory = new File(destinationDirectoryLocation);
        if (sourceDirectory.exists() && !destinationDirectory.exists()) {
            FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
        }
    }

    /**
     * Method used to write lines to the copied files.
     *
     * @param decipher - Decipher entity.
     * @throws IOException - If the file cannot be read or written.
     */
    public static void addClassLines(Decipher decipher) throws IOException {
        for (Entity entity : decipher.getBackend().getEntity()) {
            List<File> files = getTemplateFiles(StringUtils.toLowerCamelCase(decipher.getBackend().getName()), StringUtils.toUpperCamelCase(entity.getName()));
            FileUtil.removeClassLines(files);
            FileUtil.addClassLines(entity, decipher, files);
        }
    }

    /**
     * Method used to get the template files.
     *
     * @param module     - Module name.
     * @param entityName - Entity name.
     * @return - List of files.
     */
    private static List<File> getTemplateFiles(String module, String entityName) {
        List<File> files = new ArrayList<>();
        String routePath = "../" + module + "/src/main/java/com/project/" + module + "/content/" + entityName;
        files.add(new File(routePath + "/adapter/in/rest/dtos/" + entityName + "Dto.java"));
        files.add(new File(routePath + "/adapter/out/persistence/entity/" + entityName + "Entity.java"));
        files.add(new File(routePath + "/domain/models/" + entityName + ".java"));
        return files;
    }
}
