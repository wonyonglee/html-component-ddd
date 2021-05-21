package com.htmlcomponent.domain.model.htmlcomponent;

import lombok.Getter;

@Getter
public class PageNotFoundException extends RuntimeException {
  private Long id;

  public PageNotFoundException(Long id) {
    this.id = id;
  }
}