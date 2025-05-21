package com.flaco.jpalab.config;

import com.flaco.jpalab.model.*;
import com.flaco.jpalab.repository.AssociationRepository;
import com.flaco.jpalab.repository.DivisionRepository;
import com.flaco.jpalab.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer2 {

    @Bean
    public CommandLineRunner initNursingData(
            MemberRepository memberRepository,
            DivisionRepository divisionRepository,
            AssociationRepository associationRepository
    ) {
        return args -> {
            // members
            Member member1 = Member.builder().name("Tony Hawk").status(Status.ACTIVE).renewalDate(LocalDate.now()).build();
            Member member2 = Member.builder().name("Rodney Mullen").status(Status.LAPSED).renewalDate(LocalDate.now().minusDays(90)).build();
            Member member3 = Member.builder().name("Bryan Herman").status(Status.ACTIVE).renewalDate(LocalDate.now().minusDays(10)).build();
            Member member4 = Member.builder().name("Andrew Reynolds").status(Status.LAPSED).renewalDate(LocalDate.now().minusDays(45)).build();
            Member member5 = Member.builder().name("Daewon Song").status(Status.ACTIVE).renewalDate(LocalDate.now().minusDays(5)).build();
            Member member6 = Member.builder().name("Wade Desarmo").status(Status.LAPSED).renewalDate(LocalDate.now().minusDays(120)).build();
            Member member7 = Member.builder().name("Dennis Busenitz").status(Status.ACTIVE).renewalDate(LocalDate.now().minusDays(2)).build();

            memberRepository.saveAll(List.of(member1, member2, member3, member4, member5, member6, member7));

            // divisions
            Division division1 = Division.builder().name("Division Vans").district("Los Angeles").president(member1).members(List.of(member1)).build();
            Division division2 = Division.builder().name("Division Nike").district("Tokyo").president(member2).members(List.of(member2)).build();
            Division division3 = Division.builder().name("Division Thunder").district("Paris").president(member3).members(List.of(member3)).build();
            Division division4 = Division.builder().name("Division Spitfire").district("Venice").president(member4).members(List.of(member4)).build();
            Division division5 = Division.builder().name("Division DC").district("New York").president(member5).members(List.of(member5)).build();
            Division division6 = Division.builder().name("Division Element").district("Berlin").president(member6).members(List.of(member6)).build();
            Division division7 = Division.builder().name("Division Supreme").district("London").president(member7).members(List.of(member7)).build();

            // association
            Association association = Association.builder()
                    .name("Global Skateboarding Medical Association")
                    .divisions(List.of(division1, division2, division3, division4, division5, division6, division7))
                    .build();

            // associate division to association
            association.getDivisions().forEach(div -> div.setAssociation(association));

            associationRepository.save(association);

            System.out.println();
            System.out.println("PROCESS COMPLETED!");
            System.out.println("Associations, members and divisions are saved! Stay safe!");
            System.out.println();
            System.out.println("---------------------------------------------------------");
            System.out.println();

        };
    }
}