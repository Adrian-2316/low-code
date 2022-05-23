package com.project.lowcode.content.decipher.adapter.in.rest.dtos.frontend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author adrian.moral created on 23/05/2022 - 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WidgetDto {
    private String widgetId;
    private String tag;
    private String widgetName;
    private Boolean selected;
    private String cssClass;
    private AttrsDto attrs;
}
