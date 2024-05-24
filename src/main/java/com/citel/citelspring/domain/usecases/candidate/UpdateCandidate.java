package com.citel.citelspring.domain.usecases.candidate;

import com.citel.citelspring.domain.repositories.CandidateRepository;

public class UpdateCandidate {
  final CandidateRepository repository;

  public UpdateCandidate(CandidateRepository repository) {
    this.repository = repository;
  }

  public void call(int id) {
    repository.updateCandidate(id);
  }
}
