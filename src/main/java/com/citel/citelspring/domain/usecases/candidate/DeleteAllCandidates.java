package com.citel.citelspring.domain.usecases.candidate;

import com.citel.citelspring.domain.repositories.CandidateRepository;

public class DeleteAllCandidates {
  final CandidateRepository repository;

  public DeleteAllCandidates(CandidateRepository repository) {
    this.repository = repository;
  }

  public void call() {
    repository.deleteAllCandidates();
  }
}
