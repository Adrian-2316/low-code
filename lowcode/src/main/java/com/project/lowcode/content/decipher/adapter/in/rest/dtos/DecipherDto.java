package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecipherDto {
    private String id;
    @NotNull
    private BackendDto backend;
    private FrontendDto frontend;
}
