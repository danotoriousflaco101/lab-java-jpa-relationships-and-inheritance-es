package com.flaco.jpalab.config;

import com.flaco.jpalab.model.*;
import com.flaco.jpalab.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer3 {

    @Bean
    public CommandLineRunner initEventData(
            EventRepository eventRepository,
            GuestRepository guestRepository,
            ConferenceRepository conferenceRepository,
            SpeakerRepository speakerRepository,
            ExhibitionRepository exhibitionRepository
    ) {
        return args -> {
            // Conference
            Conference conference = Conference.builder()
                    .title("Hip-Hop Summit 2025")
                    .date(LocalDate.of(2025, 9, 15))
                    .duration(3)
                    .location("New York")
                    .build();

            Speaker speaker1 = Speaker.builder()
                    .name("KRS-One")
                    .presentationDuration(60)
                    .conference(conference)
                    .build();

            Speaker speaker2 = Speaker.builder()
                    .name("Nas")
                    .presentationDuration(45)
                    .conference(conference)
                    .build();

            conference.getSpeakers().addAll(List.of(speaker1, speaker2));

            Guest guest1 = Guest.builder()
                    .name("Big Daddy Kane")
                    .status(GuestStatus.ATTENDING)
                    .event(conference)
                    .build();

            Guest guest2 = Guest.builder()
                    .name("Tupac")
                    .status(GuestStatus.NOT_ATTENDING)
                    .event(conference)
                    .build();

            conference.getGuests().addAll(List.of(guest1, guest2));

            // Exhibition
            Exhibition exhibition = Exhibition.builder()
                    .title("X-Games")
                    .date(LocalDate.of(2025, 10, 5))
                    .duration(2)
                    .location("Los Angeles")
                    .build();

            Guest guest3 = Guest.builder()
                    .name("Chad Muska")
                    .status(GuestStatus.NO_RESPONSE)
                    .event(exhibition)
                    .build();

            exhibition.getGuests().add(guest3);

            // save
            conferenceRepository.save(conference);
            exhibitionRepository.save(exhibition);

            System.out.println();
            System.out.println("PROCESS COMPLETED!");
            System.out.println("Events loaded successfully! Have fun! ");
            System.out.println();
            System.out.println("---------------------------------------");
            System.out.println();
        };
    }
}