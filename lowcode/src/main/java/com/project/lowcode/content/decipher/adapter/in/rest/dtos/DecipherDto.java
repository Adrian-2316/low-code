package com.project.lowcode.content.decipher.adapter.in.rest.dtos;

import com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend.BackendDto;
import com.project.lowcode.content.decipher.adapter.in.rest.dtos.frontend.FrontendDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DecipherDto {
    private String id;
    @NotNull
    @Valid
    private BackendDto backend;
    private FrontendDto frontend;
}
