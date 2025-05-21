package com.flaco.jpalab.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String district;

    @ManyToOne
    private Association association;

    @ManyToOne
    private Member president;

    @ManyToMany
    @Builder.Default
    private List<Member> members = new ArrayList<>();
}