package com.citel.citelspring.domain.usecases.candidate;

import java.util.List;

import com.citel.citelspring.domain.entities.Candidate;
import com.citel.citelspring.domain.repositories.CandidateRepository;

public class ListCandidates {
  final CandidateRepository repository;

  public ListCandidates(CandidateRepository repository) {
    this.repository = repository;
  }

  public List<Candidate> call() {
    return repository.getAllCandidates();
  }
}
