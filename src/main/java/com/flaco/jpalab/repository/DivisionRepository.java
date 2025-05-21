package com.flaco.jpalab.repository;

import com.flaco.jpalab.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {
    // Esempio: trova divisioni per distretto
    List<Division> findByDistrict(String district);

    // Esempio: trova divisioni guidate da un certo presidente (member)
    List<Division> findByPresidentId(Long presidentId);
}