package com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author adrian.moral created on 23/05/2022 - 17:05
 */
@Data
@Builder
@AllArgsConstructor

@NoArgsConstructor

public class WidgetsEntity {
    private Map<String, WidgetEntity> widgets;
}
