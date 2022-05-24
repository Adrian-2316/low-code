package com.project.lowcode.content.decipher.adapter.in.rest.dtos.frontend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagesDto {

    private String selected;
    private List<String> list;
}
