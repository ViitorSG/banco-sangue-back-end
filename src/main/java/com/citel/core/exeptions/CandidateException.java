package com.citel.core.exeptions;

public class CandidateException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public CandidateException(String message) {
    super(message);
  }

  public CandidateException(String message, Throwable cause) {
    super(message, cause);
  }
}
