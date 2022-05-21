package com.project.lowcode.content.generator.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratorJpaRepository extends JpaRepository<GeneratorEntity, Long> {

}
