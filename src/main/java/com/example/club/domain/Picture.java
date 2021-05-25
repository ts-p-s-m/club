package com.example.club.domain;

import javax.persistence.*;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Trainer trainer;

    @OneToOne(fetch = FetchType.LAZY)
    private MartialArt martialArt;

    public Picture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public MartialArt getMartialArt() {
        return martialArt;
    }

    public void setMartialArt(MartialArt martialArt) {
        this.martialArt = martialArt;
    }
}