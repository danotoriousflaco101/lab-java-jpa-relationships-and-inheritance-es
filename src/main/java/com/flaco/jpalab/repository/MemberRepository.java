package com.flaco.jpalab.repository;

import com.flaco.jpalab.model.Member;
import com.flaco.jpalab.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Esempio: trova tutti i membri con status ACTIVE
    List<Member> findByStatus(Status status);
}