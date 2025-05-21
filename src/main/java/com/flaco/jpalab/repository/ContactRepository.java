package com.flaco.jpalab.repository;

import com.flaco.jpalab.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}