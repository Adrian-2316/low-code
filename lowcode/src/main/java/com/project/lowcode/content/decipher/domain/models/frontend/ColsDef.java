package com.project.lowcode.content.decipher.domain.models.frontend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author adrian.moral created on 23/05/2022 - 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColsDef {
    private String header;
    private List<String> dataQuery;
}
