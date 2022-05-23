package com.project.lowcode.content.decipher.domain.models.frontend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrontendDto {

    private PagesDto pages;
    private LayoutDto layout;
    private SlotsDto slots;
    private WidgetsDto widgets;
    private DrawersDto drawers;
    private DialogDto dialog;
    private ContextMenuDto contextMenu;

}
