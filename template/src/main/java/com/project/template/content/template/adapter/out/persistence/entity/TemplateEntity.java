package com.project.template.content.template.adapter.out.persistence.entity;

import com.project.template.content.template.domain.models.Template;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_template", schema = "template")
public class TemplateEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    //Insert your code here

    public void copyProperties(Template template) {
        BeanUtils.copyProperties(template, this);
    }
}
