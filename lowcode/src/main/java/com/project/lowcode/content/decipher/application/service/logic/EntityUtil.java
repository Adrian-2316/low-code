package com.project.lowcode.content.decipher.application.service.logic;

import com.project.lowcode.shared.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntityUtil {

    public static void replaceFiles(String name, String s) {
    }


    /**
     * Replaces the folders in the module.
     * MUST BE CALLED AFTER THE MODULE HAS BEEN CLONED.
     * MUST BE ORDERED FROM OUTSIDE TO INSIDE.
     *
     * @param name   the name of the entity
     * @param module the name of the module
     */
    public static void replaceFolders(String module, String name) {
        module = StringUtils.toLowerCamelCase(module);
        name = StringUtils.toLowerCamelCase(name);
        String upperModule = StringUtils.toUpperCamelCase(module);
        LinkedHashMap<String, String> folderMap = new LinkedHashMap<>();
        String entityPath = "../" + module + "/src/main/java/com/project/" + module + "/content/" + name;
        String routePath = "/adapter/in/rest/";
        // Adapter in
        folderMap.put(entityPath + routePath + "dtos/TemplateDto.java", entityPath + routePath + "dtos/" + upperModule + "Dto.java");
        folderMap.put(entityPath + routePath + "dtos/TemplateDtoMapper.java", entityPath + routePath + "dtos/" + upperModule + "DtoMapper.java");
        folderMap.put(entityPath + routePath + "TemplateController.java", entityPath + routePath + upperModule + "Controller.java");
        routePath = "/adapter/out/persistence/";
        // Adapter out
        folderMap.put(entityPath + routePath + "TemplateJpaRepository.java", entityPath + routePath + upperModule + "JpaRepository.java");
        folderMap.put(entityPath + routePath + "TemplateRepository.java", entityPath + routePath + upperModule + "Repository.java");
        folderMap.put(entityPath + routePath + "entity/TemplateEntity.java", entityPath + routePath + "entity/" + upperModule + "Entity.java");
        folderMap.put(entityPath + routePath + "entity/TemplateEntityMapper.java", entityPath + routePath + "entity/" + upperModule + "EntityMapper.java");
        routePath = "/application/service/";
        // Application
        folderMap.put(entityPath + routePath + "TemplateCommand.java", entityPath + routePath + upperModule + "Command.java");
        folderMap.put(entityPath + routePath + "TemplateService.java", entityPath + routePath + upperModule + "Service.java");
        folderMap.put(entityPath + routePath + "ports/in/TemplatePort.java", entityPath + routePath + "ports/in/" + upperModule + "Port.java");
        folderMap.put(entityPath + routePath + "ports/out/TemplateMapper.java", entityPath + routePath + "ports/out/" + upperModule + "Mapper.java");
        folderMap.put(entityPath + routePath + "ports/out/TemplateRepositoryPort.java", entityPath + routePath + "ports/out/" + upperModule + "RepositoryPort.java");
        routePath = "/domain/models/";
        // Domain
        folderMap.put(entityPath + routePath + "/Template.java", entityPath + routePath + upperModule + ".java");


        for (Map.Entry<String, String> entry : folderMap.entrySet()) {
            File folderToBeModified = new File(entry.getKey());
            FileUtil.renameFolder(folderToBeModified, new File(entry.getValue()));
        }
    }


    public static void cloneModule(String module, String name) throws IOException {
        module = StringUtils.toLowerCamelCase(module);
        String sourceDirectoryLocation = "../" + module + "/src/main/java/com/project/" + module + "/content/template";
        String destinationDirectoryLocation = "../" + module + "/src/main/java/com/project/" + module + "/content/" + StringUtils.toLowerCamelCase(name);
        File sourceDirectory = new File(sourceDirectoryLocation);
        File destinationDirectory = new File(destinationDirectoryLocation);
        if (sourceDirectory.exists() && !destinationDirectory.exists()) {
            FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
        }
    }
}
