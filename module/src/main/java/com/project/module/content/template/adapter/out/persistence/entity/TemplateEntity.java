package com.project.module.content.template.adapter.out.persistence.entity;

// Generation import code segment start
// Generation import code segment end

import com.project.module.content.template.domain.models.Template;
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
    // Generation code segment start
    // Generation code segment end

    public void copyProperties(Template template) {
        BeanUtils.copyProperties(template, this);
    }
}
