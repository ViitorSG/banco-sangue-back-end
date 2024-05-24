package com.citel.citelspring.domain.usecases.candidate;

import com.citel.citelspring.domain.entities.Candidate;
import com.citel.citelspring.domain.repositories.CandidateRepository;

public class CreateCandidate {
  final CandidateRepository repository;

  public CreateCandidate(CandidateRepository repository) {
    this.repository = repository;
  }

  public void call(Candidate candidate) {
    repository.createCandidate(candidate);
  }
}
