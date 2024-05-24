package com.citel.citelspring.data.models;

public class CandidateResponseModel {

  public CandidateResponseModel() {
  }

  int code;
  String message;

  public CandidateResponseModel(int code, String message) {
    super();
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
