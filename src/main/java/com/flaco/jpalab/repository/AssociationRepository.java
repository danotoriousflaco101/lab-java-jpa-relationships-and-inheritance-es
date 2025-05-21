package com.flaco.jpalab.repository;

import com.flaco.jpalab.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
    // Esempio: trova per nome
    Association findByName(String name);
}