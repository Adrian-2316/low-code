package com.project.template.content.template.adapter.out.persistence;

import com.project.template.content.template.adapter.out.persistence.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateJpaRepository extends JpaRepository<TemplateEntity, Long> {

}
