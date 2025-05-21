package com.flaco.jpalab.repository;

import com.flaco.jpalab.model.BillableTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillableTaskRepository extends JpaRepository<BillableTask, Long> {
}