package com.project.lowcode.content.decipher.domain.models;

import com.project.lowcode.content.decipher.domain.models.backend.Backend;
import com.project.lowcode.content.decipher.domain.models.frontend.Frontend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Decipher {
    private String id;
    private Backend backend;
    private Frontend frontend;
}
