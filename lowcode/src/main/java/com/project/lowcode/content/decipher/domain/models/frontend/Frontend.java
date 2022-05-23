package com.project.lowcode.content.decipher.domain.models.frontend;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Frontend {
    private Pages pages;
    private Layout layout;
    private Slots slots;
    private Widgets widgets;
    private Drawers drawers;
    private Dialog dialog;
    private ContextMenu contextMenu;
}
