package com.project.lowcode.content.decipher.domain.models.frontend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Layout {

    private String name;
    private List<Shape> list;
}
