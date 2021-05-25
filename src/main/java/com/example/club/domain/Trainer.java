package com.example.club.domain;

import javax.persistence.*;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Picture picture;

    private String name;
    private String secondName;
    private String surname;

    private String martialArt;

    private int dan;
    private int yearsExperience;

    private String beltColor;

    public Trainer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMartialArt() {
        return martialArt;
    }

    public void setMartialArt(String martialArt) {
        this.martialArt = martialArt;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getBeltColor() {
        return beltColor;
    }

    public void setBeltColor(String beltColor) {
        this.beltColor = beltColor;
    }
}
