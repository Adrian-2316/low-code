package com.project.lowcode.content.json.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Json {
    private String id;
    private String type;
    private Field[] fields;

}
