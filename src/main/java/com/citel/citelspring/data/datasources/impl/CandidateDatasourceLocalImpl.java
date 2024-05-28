package com.citel.citelspring.data.datasources.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.citel.citelspring.data.datasources.CandidateDatasourcesLocal;
import com.citel.citelspring.data.datasources.JpaCandidateRepository;
import com.citel.citelspring.data.models.candidate.CandidateModel;

@Service
public class CandidateDatasourceLocalImpl implements CandidateDatasourcesLocal {

    final JpaCandidateRepository jpaCandidateRepository;

    public CandidateDatasourceLocalImpl(JpaCandidateRepository jpaCandidateRepository) {
        this.jpaCandidateRepository = jpaCandidateRepository;
    }

    @Override
    public void createCandidate(CandidateModel candidateModel) {
        jpaCandidateRepository.save(candidateModel);
    }

    @Override
    public List<CandidateModel> getAllCandidates() {
        return jpaCandidateRepository.findAll();
    }

    public CandidateModel updateValuesForCandidate(Optional<CandidateModel> existingCandidate, CandidateModel newCandidateData) {
        CandidateModel candidateToUpdate = existingCandidate.get();

        candidateToUpdate.setNome(newCandidateData.getNome());
        candidateToUpdate.setRg(newCandidateData.getRg());
        candidateToUpdate.setData_nasc(newCandidateData.getData_nasc());
        candidateToUpdate.setSexo(newCandidateData.getSexo());
        candidateToUpdate.setMae(newCandidateData.getMae());
        candidateToUpdate.setPai(newCandidateData.getPai());
        candidateToUpdate.setEmail(newCandidateData.getEmail());
        candidateToUpdate.setCep(newCandidateData.getCep());
        candidateToUpdate.setEndereco(newCandidateData.getEndereco());
        candidateToUpdate.setNumero(newCandidateData.getNumero());
        candidateToUpdate.setBairro(newCandidateData.getBairro());
        candidateToUpdate.setCidade(newCandidateData.getCidade());
        candidateToUpdate.setEstado(newCandidateData.getEstado());
        candidateToUpdate.setTelefone_fixo(newCandidateData.getTelefone_fixo());
        candidateToUpdate.setCelular(newCandidateData.getCelular());
        candidateToUpdate.setAltura(newCandidateData.getAltura());
        candidateToUpdate.setPeso(newCandidateData.getPeso());
        candidateToUpdate.setTipo_sanguineo(newCandidateData.getTipo_sanguineo());

        return candidateToUpdate;
    }

    @Override
    public void updateCandidate(CandidateModel newCandidateData) {
        Optional<CandidateModel> existingCandidate = Optional.ofNullable(jpaCandidateRepository.findByCpf(newCandidateData.getCpf()));
        if (existingCandidate.isPresent()) {
            CandidateModel candidateUpdated = updateValuesForCandidate(existingCandidate, newCandidateData);
            jpaCandidateRepository.save(candidateUpdated);
        } else {
            jpaCandidateRepository.save(newCandidateData);
        }
    }

    @Override
    public void deleteAllCandidates() {
        jpaCandidateRepository.deleteAll();
    }
}
