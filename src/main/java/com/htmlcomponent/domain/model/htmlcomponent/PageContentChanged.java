package com.htmlcomponent.domain.model.htmlcomponent;

import com.htmlcomponent.domain.event.DomainEvent;
import com.htmlcomponent.domain.model.vo.HtmlContent;
import lombok.Value;

/**
 * 페이지 내용 변경됨 이벤트
 * @see Page#changeHtmlContent(String, HtmlContent)
 * @see HistoryAppender#appendHistoryBy(PageContentChanged)
 */
@Value
public class PageContentChanged implements DomainEvent {
  private HtmlComponent htmlComponent;
  private Long pageId;
  private String author;
  private HtmlContent htmlContent;

  public PageContentChanged(Page page, HtmlContent htmlContent) {
    this.htmlComponent = page.getHtmlComponent();
    this.pageId = page.getId();
    this.author = page.getAuthor();
    this.htmlContent = htmlContent;
  }
}