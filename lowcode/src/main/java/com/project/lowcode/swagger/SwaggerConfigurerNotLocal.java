package com.project.lowcode.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!local")
@Configuration
public class SwaggerConfigurerNotLocal {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("Lowcode").packagesToScan("com.project.lowcode.content").pathsToMatch("/**").build();

    }
}
