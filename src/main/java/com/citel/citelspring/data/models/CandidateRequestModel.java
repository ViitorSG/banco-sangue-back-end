package com.citel.citelspring.data.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.citel.citelspring.domain.entities.Candidate;

public class CandidateRequestModel {

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

  public CandidateRequestModel(int id, String name, String cpf, String rg, LocalDate birth, String gender,
      String mother,
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

  public static Candidate toCandidate(CandidateModel candidateModel) {
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

  public static CandidateModel toCandidateModel(Candidate candidate) {
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

  public static List<Candidate> toCandidateList(List<CandidateModel> candidateModel) {
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

  }
}