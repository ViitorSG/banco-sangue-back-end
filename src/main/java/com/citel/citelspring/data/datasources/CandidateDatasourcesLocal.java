package com.citel.citelspring.data.datasources;

import java.util.List;

import com.citel.citelspring.data.models.CandidateModel;

public interface CandidateDatasourcesLocal {
  public void createCandidate(CandidateModel candidateModel);

  public void updateCandidate(int id);

  public void deleteAllCandidates();

  public List<CandidateModel> getAllCandidates();
}
