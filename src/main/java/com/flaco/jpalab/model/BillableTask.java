package com.flaco.jpalab.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BillableTask extends Task {

    private BigDecimal hourlyRate;

    public BillableTask(String title, LocalDate dueDate, boolean completed, BigDecimal hourlyRate) {
        super(title, dueDate, completed);
        this.hourlyRate = hourlyRate;
    }
}