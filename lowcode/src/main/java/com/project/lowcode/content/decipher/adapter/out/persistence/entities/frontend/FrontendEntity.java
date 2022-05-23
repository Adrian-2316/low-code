package com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FrontendEntity {
    private PagesEntity pagesEntity;
    private LayoutEntity layoutEntity;
    private SlotsEntity slotsEntity;
    private WidgetsEntity widgetsEntity;
    private DrawersEntity drawersEntity;
    private DialogEntity dialogEntity;
    private ContextMenuEntity contextMenuEntity;
}
