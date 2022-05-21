package com.project.lowcode.swagger;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class SwaggerController {

    @GetMapping(value = "/")
    public void redirect(final HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}
