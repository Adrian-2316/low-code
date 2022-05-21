package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackendDto {
    @NotNull
    private String name;
    private EntityDto entity;
}
