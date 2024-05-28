package com.citel.citelspring.data.models.candidate;

import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "candidate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class CandidateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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

    public CandidateModel(CandidateModel candidateModel) {
        this.id = candidateModel.getId();
        this.nome = candidateModel.getNome();
        this.cpf = candidateModel.getCpf();
        this.rg = candidateModel.getRg();
        this.data_nasc = candidateModel.getData_nasc();
        this.sexo = candidateModel.getSexo();
        this.mae = candidateModel.getMae();
        this.pai = candidateModel.getPai();
        this.email = candidateModel.getEmail();
        this.cep = candidateModel.getCep();
        this.endereco = candidateModel.getEndereco();
        this.numero = candidateModel.getNumero();
        this.bairro = candidateModel.getBairro();
        this.cidade = candidateModel.getCidade();
        this.estado = candidateModel.getEstado();
        this.telefone_fixo = candidateModel.getTelefone_fixo();
        this.celular = candidateModel.getCelular();
        this.altura = candidateModel.getAltura();
        this.peso = candidateModel.getPeso();
        this.tipo_sanguineo = candidateModel.getTipo_sanguineo();
    }

    public int getAge() {
        return LocalDate.now().getYear() - data_nasc.getYear();
    }
}