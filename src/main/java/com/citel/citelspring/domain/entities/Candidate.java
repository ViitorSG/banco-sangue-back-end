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
    String zipCode;
    String address;
    int number;
    String neighborhood;
    String city;
    String state;
    String landline;
    String mobile;
    double height;
    double weight;
    String bloodType;

    public Candidate(int id, String name, String cpf, String rg, LocalDate birthDate, String gender,
            String mother, String father, String email, String zipCode, String address, int number,
            String neighborhood, String city, String state, String landline, String mobile, double height,
            double weight, String bloodType) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.email = email;
        this.zipCode = zipCode;
        this.address = address;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.landline = landline;
        this.mobile = mobile;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
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
                ", zipCode=" + zipCode +
                ", address=" + address +
                ", number=" + number +
                ", neighborhood=" + neighborhood +
                ", city=" + city +
                ", state=" + state +
                ", landline=" + landline +
                ", mobile=" + mobile +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodType=" + bloodType +
                "]";
    }
}
