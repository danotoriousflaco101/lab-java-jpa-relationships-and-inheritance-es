package com.flaco.jpalab.repository;

import com.flaco.jpalab.model.InternalTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalTaskRepository extends JpaRepository<InternalTask, Long> {
}