package com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author adrian.moral created on 23/05/2022 - 17:27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DrawersEntity {
    private LeftDrawerEntity leftDrawer;
    private RightDrawerEntity rightDrawer;
}
