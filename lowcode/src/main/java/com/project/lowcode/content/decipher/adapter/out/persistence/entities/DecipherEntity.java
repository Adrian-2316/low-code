package com.project.lowcode.content.decipher.adapter.out.persistence.entities;

import com.project.lowcode.content.decipher.adapter.out.persistence.entities.backend.BackendEntity;
import com.project.lowcode.content.decipher.domain.models.frontend.Frontend;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "JSONs")
public class DecipherEntity {
    @Id
    private String id;
    private BackendEntity backend;
    private Frontend frontend;

}
