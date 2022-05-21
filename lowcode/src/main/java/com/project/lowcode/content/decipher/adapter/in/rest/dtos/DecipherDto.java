package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecipherDto {
    private String id;
    private BackendDto backend;
    private FrontendDto frontend;
}
