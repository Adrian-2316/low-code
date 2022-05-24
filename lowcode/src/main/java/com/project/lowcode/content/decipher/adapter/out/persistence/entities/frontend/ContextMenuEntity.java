package com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author adrian.moral created on 23/05/2022 - 17:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ContextMenuEntity {
    private List<String> options;
    private Integer posx;
    private Integer posy;
}
