package com.project.lowcode.content.decipher.adapter.in.rest.dtos.backend;

import com.project.lowcode.validations.annotations.FieldValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntityDto {
    @NotNull
    private String name;
    @FieldValidator
    private List<FieldDto> fields;
}
