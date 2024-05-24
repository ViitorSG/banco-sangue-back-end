package com.citel.citelspring.domain.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Candidate {
    int id;
    String name;
    String cpf;
    String rg;
    LocalDate birthDate;
    String gender;
    String mother;
    String father;
    String email;
    Address address;
    BloodType bloodType;
    String landline;
    String mobile;
    double height;
    double weight;

    public Candidate(int id, String name, String cpf, String rg, LocalDate birthDate, String gender,
            String mother, String father, String email, String landline, String mobile, double height,
            double weight, BloodType bloodType, Address address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.email = email;
        this.landline = landline;
        this.mobile = mobile;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return LocalDate.now().getYear() - this.birthDate.getYear();
    }

    public double getBmi() {
        return this.weight / (this.height * this.height);
    }

    public void setBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    @Override
    public String toString() {
        return "Candidate [id=" + id +
                ", name=" + name +
                ", cpf=" + cpf +
                ", rg=" + rg +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", mother=" + mother +
                ", father=" + father +
                ", email=" + email +
                ", address=" + address +

                ", landline=" + landline +
                ", mobile=" + mobile +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodType=" + bloodType +
                "]";
    }
}
