package com.project.lowcode.content.json.adapter.out.persistence.entities;

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
@Document(collection = "json")
public class JsonEntity {
    @Id
    private String id;
    private String type;
    private FieldEntity[] fields;

}
