package com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayoutEntity {

    private String name;
    private List<ShapeEntity> list;
}
