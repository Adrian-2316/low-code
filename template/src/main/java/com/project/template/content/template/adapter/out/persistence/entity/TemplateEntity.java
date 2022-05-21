package com.project.template.content.template.adapter.out.persistence.entity;

import com.project.template.content.template.domain.models.Template;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "template", schema = "template")
public class TemplateEntity {
    @Id
    @GeneratedValue
    private Long id;

    public void copyProperties(Template template) {
        BeanUtils.copyProperties(template, this);
    }
}
