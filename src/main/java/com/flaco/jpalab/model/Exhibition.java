package com.flaco.jpalab.model;

import jakarta.persistence.Entity;

import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Exhibition extends Event {

    @Builder
    public Exhibition(Long id, String title, LocalDate date, Integer duration, String location) {
        super(id, title, date, duration, location);
    }
}