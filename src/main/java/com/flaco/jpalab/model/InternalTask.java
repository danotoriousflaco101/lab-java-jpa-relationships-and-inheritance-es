package com.flaco.jpalab.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InternalTask extends Task {

    public InternalTask(String title, LocalDate dueDate, boolean completed) {
        super(title, dueDate, completed);
    }
}