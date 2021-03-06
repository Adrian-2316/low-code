package com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrontendEntity {
    private PagesEntity pages;
    private LayoutEntity layout;
    private SlotsEntity slots;
    private WidgetsEntity widgets;
    private DrawersEntity drawers;
    private DialogEntity dialog;
    private ContextMenuEntity contextMenu;
}
