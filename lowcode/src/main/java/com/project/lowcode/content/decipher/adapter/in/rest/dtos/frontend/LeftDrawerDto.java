package com.project.lowcode.content.decipher.adapter.in.rest.dtos.frontend;

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
public class LeftDrawerDto {
    private String mode;
    private String view;
    private String data;
}
