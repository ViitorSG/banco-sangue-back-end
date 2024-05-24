package com.citel.citelspring.data.datasources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citel.citelspring.data.models.candidate.CandidateModel;

@Repository
public interface JpaCandidateRepository extends JpaRepository<CandidateModel, Integer> {

}
