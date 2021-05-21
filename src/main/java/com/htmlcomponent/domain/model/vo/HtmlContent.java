package com.htmlcomponent.domain.model.vo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HtmlContent implements Serializable {
  @Lob
  private String html;
  @Lob
  private String js;
  @Lob
  private String css;

  @Builder
  public HtmlContent(String html, String js, String css) {
    this.html = html;
    this.js = js;
    this.css = css;
  }
}