package com.htmlcomponent.domain.model.htmlcomponent;

import lombok.Getter;

@Getter
public class HtmlComponentValidationException extends RuntimeException {
  private String message;

  public HtmlComponentValidationException(String message) {
    this.message = message;
  }
}