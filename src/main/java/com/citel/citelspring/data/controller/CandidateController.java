package com.citel.citelspring.data.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.citel.citelspring.data.models.candidate.CandidateModel;
import com.citel.citelspring.data.models.candidate.CandidateRequestModel;
import com.citel.citelspring.data.models.candidate.CandidateResponseModel;
import com.citel.citelspring.domain.usecases.candidate.CreateCandidate;

public class CandidateController {

  final CreateCandidate createCandidate;

  public CandidateController(CreateCandidate createCandidate) {
    this.createCandidate = createCandidate;
  }

  @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CandidateResponseModel> createCandidate(@RequestBody CandidateModel candidateModel) {
    try {
      createCandidate.call(CandidateRequestModel.toCandidate(candidateModel));

      return new ResponseEntity<CandidateResponseModel>(
          new CandidateResponseModel(HttpStatus.OK.value(), HttpStatus.OK.name()), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<CandidateResponseModel>(
          new CandidateResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
