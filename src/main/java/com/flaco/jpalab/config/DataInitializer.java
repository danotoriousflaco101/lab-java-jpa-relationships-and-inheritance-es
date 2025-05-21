package com.flaco.jpalab.config;

import com.flaco.jpalab.model.Contact;
import com.flaco.jpalab.model.Name;
import com.flaco.jpalab.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ContactRepository contactRepository) {
        return args -> {
            Contact contact1 = new Contact(
                    null,
                    "Princeton-Plainsboro Teaching Hospital",
                    "Head of the Department of Diagnostic Medicine",
                    new Name("Dr.", "Gregory", null, "House")
            );

            Contact contact2 = new Contact(
                    null,
                    "Electric Lady Studios",
                    "Founder",
                    new Name("Mr.", "James", "Marshall", "Hendrix")
            );

            Contact contact3 = new Contact(
                    null,
                    "Scuderia Ferrari",
                    "F1 Driver",
                    new Name("Sir", "Lewis", "Carl", "Hamilton")
            );

            contactRepository.save(contact1);
            contactRepository.save(contact2);
            contactRepository.save(contact3);

            System.out.println();
            System.out.println("PROCESS COMPLETED!");
            System.out.println("Contacts are being saved! Have a nice day!");
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println();
        };
    }
}