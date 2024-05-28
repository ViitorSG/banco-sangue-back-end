package com.citel.citelspring.data.models.candidate;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RequestCandidate {
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

}
