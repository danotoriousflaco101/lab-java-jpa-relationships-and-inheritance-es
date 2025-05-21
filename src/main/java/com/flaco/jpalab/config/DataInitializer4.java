package com.flaco.jpalab.config;

import com.flaco.jpalab.model.BillableTask;
import com.flaco.jpalab.model.InternalTask;
import com.flaco.jpalab.repository.BillableTaskRepository;
import com.flaco.jpalab.repository.InternalTaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataInitializer4 {

    @Bean
    public CommandLineRunner initTaskData(
            BillableTaskRepository billableTaskRepo,
            InternalTaskRepository internalTaskRepo
    ) {
        return args -> {

            // Billable Tasks
            billableTaskRepo.save(new BillableTask(
                    "Skate Podcast",
                    LocalDate.of(2025, 6, 1),
                    false,
                    new BigDecimal("50.00")
            ));

            billableTaskRepo.save(new BillableTask(
                    "Social Media Content",
                    LocalDate.of(2025, 6, 3),
                    false,
                    new BigDecimal("60.00")
            ));

            billableTaskRepo.save(new BillableTask(
                    "Skate Class",
                    LocalDate.of(2025, 6, 5),
                    true,
                    new BigDecimal("40.00")
            ));

            // Internal Tasks
            internalTaskRepo.save(new InternalTask(
                    "Team meeting",
                    LocalDate.of(2025, 5, 22),
                    true
            ));

            internalTaskRepo.save(new InternalTask(
                    "Video Shooting",
                    LocalDate.of(2025, 5, 25),
                    false
            ));

            internalTaskRepo.save(new InternalTask(
                    "Photo Shooting",
                    LocalDate.of(2025, 5, 28),
                    false
            ));

            System.out.println();
            System.out.println("PROCESS COMPLETED!");
            System.out.println("Tasks are being saved! Have a nice shift! ");
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println();
        };
    }
}