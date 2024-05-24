package com.citel.citelspring.data.repositories;

import java.util.List;

import com.citel.citelspring.data.datasources.CandidateDatasourcesLocal;
import com.citel.citelspring.data.models.CandidateModel;
import com.citel.citelspring.domain.entities.Candidate;
import com.citel.citelspring.domain.repositories.CandidateRepository;

public class CandidateRepositoryImpl implements CandidateRepository {

  final CandidateDatasourcesLocal candidateDatasourcesLocal;

  public CandidateRepositoryImpl(CandidateDatasourcesLocal candidateDatasourcesLocal) {
    this.candidateDatasourcesLocal = candidateDatasourcesLocal;
  }

  @Override
  public void createCandidate(Candidate candidate) {
    CandidateModel candidateModel = new CandidateModel(
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
    candidateDatasourcesLocal.createCandidate(candidateModel.toCandidateModel(candidate));

  }

  @Override
  public void updateCandidate(int id) {
    candidateDatasourcesLocal.updateCandidate(id);
  }

  @Override
  public void deleteAllCandidates() {
    candidateDatasourcesLocal.deleteAllCandidates();
  }

  @Override
  public List<Candidate> getAllCandidates() {
    CandidateModel candidateModel = new CandidateModel();
    return candidateModel.toCandidateList(candidateDatasourcesLocal.getAllCandidates());
  };
}
