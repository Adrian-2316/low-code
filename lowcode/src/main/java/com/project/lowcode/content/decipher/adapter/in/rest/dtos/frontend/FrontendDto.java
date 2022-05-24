package com.project.lowcode.content.decipher.adapter.in.rest.dtos.frontend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
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
