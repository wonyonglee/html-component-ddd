package com.htmlcomponent.domain.model.htmlcomponent;

import lombok.Getter;

@Getter
public class HtmlComponentNotFoundException extends RuntimeException {
  private Long id;

  public HtmlComponentNotFoundException(Long id) {
    this.id = id;
  }
}