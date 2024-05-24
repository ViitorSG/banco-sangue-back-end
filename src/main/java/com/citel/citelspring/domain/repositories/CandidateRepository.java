package com.citel.citelspring.domain.repositories;

import java.util.List;

import com.citel.citelspring.domain.entities.Candidate;

public interface CandidateRepository {
  public void createCandidate(Candidate candidate);

  public void updateCandidate(int id);

  public void deleteAllCandidates();

  public List<Candidate> getAllCandidates();
}
