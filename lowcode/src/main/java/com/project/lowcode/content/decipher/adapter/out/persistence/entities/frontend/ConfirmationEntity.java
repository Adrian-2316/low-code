package com.project.lowcode.content.decipher.adapter.out.persistence.entities.frontend;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author adrian.moral created on 23/05/2022 - 17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationEntity {
    private Boolean opened;
    private String result;
}
