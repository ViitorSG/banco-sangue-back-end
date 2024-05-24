package com.citel.citelspring.data.models.candidate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.citel.citelspring.data.models.address.AddressModel;
import com.citel.citelspring.data.models.bloodType.BloodTypeModel;
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
  private String landline;
  private String mobile;
  private double height;
  private double weight;
  private AddressModel address;
  private BloodTypeModel bloodType;

  public CandidateModel(int id, String name, String cpf, String rg, LocalDate birth, String gender, String mother,
      String father, String email, String landline, String mobile, double height, double weight, AddressModel address,
      BloodTypeModel bloodType) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.rg = rg;
    this.birthDate = birth;
    this.gender = gender;
    this.mother = mother;
    this.father = father;
    this.email = email;
    this.landline = landline;
    this.mobile = mobile;
    this.height = height;
    this.weight = weight;
    this.address = address;
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
        candidateModel.getLandline(),
        candidateModel.getMobile(),
        candidateModel.getHeight(),
        candidateModel.getWeight(),
        candidateModel.getAddress(),
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
        candidate.getLandline(),
        candidate.getMobile(),
        candidate.getHeight(),
        candidate.getWeight(),
        candidate.getBloodType(),
        candidate.getAddress());
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
          temp.getAddress(),
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

  public BloodTypeModel getBloodType() {
    return bloodType;
  }

  public void setBloodType(BloodTypeModel bloodType) {
    this.bloodType = bloodType;
  }

  public AddressModel getAddress() {
    return address;
  }

  public void setAddress(AddressModel address) {
    this.address = address;
  }

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
        ", address=" + address +
        ", mobile=" + mobile +
        ", height=" + height +
        ", weight=" + weight +
        ", bloodType=" + bloodType +
        "]";
  }
}
