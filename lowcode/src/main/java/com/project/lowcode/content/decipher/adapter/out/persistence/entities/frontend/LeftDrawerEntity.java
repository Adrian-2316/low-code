package com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author adrian.moral created on 23/05/2022 - 17:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeftDrawerEntity {
    private String mode;
    private String view;
    private String data;
}
