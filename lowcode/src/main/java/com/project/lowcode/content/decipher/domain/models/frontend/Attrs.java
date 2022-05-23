package com.project.lowcode.content.decipher.domain.models.frontend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author adrian.moral created on 23/05/2022 - 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attrs {
    private String className;
    private String id;
    private String dataUrl;
    private ColsDef colsDef;
}
