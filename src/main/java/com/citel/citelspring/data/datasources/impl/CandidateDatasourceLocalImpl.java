package com.citel.citelspring.data.datasources.impl;

import java.util.List;

import com.citel.citelspring.data.datasources.CandidateDatasourcesLocal;
import com.citel.citelspring.data.datasources.JpaCandidateRepository;
import com.citel.citelspring.data.models.candidate.CandidateModel;

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

  @Override
  public void updateCandidate(int id) {
    // TODO Auto-generated method stub
  }

  @Override
  public void deleteAllCandidates() {
    jpaCandidateRepository.deleteAll();
  }
}
