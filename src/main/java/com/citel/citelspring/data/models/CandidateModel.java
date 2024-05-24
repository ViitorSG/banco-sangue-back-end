package com.citel.citelspring.data.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.citel.citelspring.domain.entities.Candidate;

@Entity
@Table(name = "candidate")
public class CandidateModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String cpf;
  private String rg;
  private LocalDate birthDate;
  private String gender;
  private String mother;
  private String father;
  private String email;
  private String zipCode;
  private String address;
  private int number;
  private String neighborhood;
  private String city;
  private String state;
  private String landline;
  private String mobile;
  private double height;
  private double weight;
  private String bloodType;

  public CandidateModel(int id, String name, String cpf, String rg, LocalDate birth, String gender, String mother,
      String father, String email, String zipCode, String address, int number, String neighborhood, String city,
      String state, String landline, String mobile, double height, double weight, String bloodType) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.rg = rg;
    this.birthDate = birth;
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

  public Candidate toCandidate(CandidateModel candidateModel) {
    return new Candidate(
        candidateModel.getId(),
        candidateModel.getName(),
        candidateModel.getCpf(),
        candidateModel.getRg(),
        candidateModel.getBirthDate(),
        candidateModel.getGender(),
        candidateModel.getMother(),
        candidateModel.getFather(),
        candidateModel.getEmail(),
        candidateModel.getZipCode(),
        candidateModel.getAddress(),
        candidateModel.getNumber(),
        candidateModel.getNeighborhood(),
        candidateModel.getCity(),
        candidateModel.getState(),
        candidateModel.getLandline(),
        candidateModel.getMobile(),
        candidateModel.getHeight(),
        candidateModel.getWeight(),
        candidateModel.getBloodType());
  }

  public CandidateModel toCandidateModel(Candidate candidate) {
    return new CandidateModel(
        candidate.getId(),
        candidate.getName(),
        candidate.getCpf(),
        candidate.getRg(),
        candidate.getBirthDate(),
        candidate.getGender(),
        candidate.getMother(),
        candidate.getFather(),
        candidate.getEmail(),
        candidate.getZipCode(),
        candidate.getAddress(),
        candidate.getNumber(),
        candidate.getNeighborhood(),
        candidate.getCity(),
        candidate.getState(),
        candidate.getLandline(),
        candidate.getMobile(),
        candidate.getHeight(),
        candidate.getWeight(),
        candidate.getBloodType());
  }

  public List<Candidate> toCandidateList(List<CandidateModel> candidateModel) {
    return candidateModel.stream().map(temp -> {
      return new Candidate(
          temp.getId(),
          temp.getName(),
          temp.getCpf(),
          temp.getRg(),
          temp.getBirthDate(),
          temp.getGender(),
          temp.getMother(),
          temp.getFather(),
          temp.getEmail(),
          temp.getZipCode(),
          temp.getAddress(),
          temp.getNumber(),
          temp.getNeighborhood(),
          temp.getCity(),
          temp.getState(),
          temp.getLandline(),
          temp.getMobile(),
          temp.getHeight(),
          temp.getWeight(),
          temp.getBloodType());
    }).collect(Collectors.toList());
  }

  public CandidateModel() {
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

  public void setBirthDate(String birthDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    this.birthDate = LocalDate.parse(birthDate, formatter);
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

  // Business logic methods
  public int getAge() {
    return LocalDate.now().getYear() - this.birthDate.getYear();
  }

  public double getBmi() {
    return this.weight / (this.height * this.height);
  }

  @Override
  public String toString() {
    return "CandidateModel [id=" + id +
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