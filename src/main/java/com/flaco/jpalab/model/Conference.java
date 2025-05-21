package com.flaco.jpalab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Conference extends Event {

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Speaker> speakers = new ArrayList<>();

    @Builder
    public Conference(Long id, String title, LocalDate date, Integer duration, String location) {
        super(id, title, date, duration, location);
    }
}