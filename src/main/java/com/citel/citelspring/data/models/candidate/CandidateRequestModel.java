package com.citel.citelspring.data.models.candidate;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class CandidateRequestModel {

  private int id;
  private String nome;
  private String cpf;
  private String rg;
  private LocalDate data_nasc;
  private String sexo;
  private String mae;
  private String pai;
  private String email;
  private String cep;
  private String endereco;
  private int numero;
  private String bairro;
  private String cidade;
  private String estado;
  private String telefone_fixo;
  private String celular;
  private double altura;
  private double peso;
  private String tipo_sanguineo;

}
