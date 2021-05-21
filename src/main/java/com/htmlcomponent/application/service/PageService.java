package com.htmlcomponent.application.service;

import com.htmlcomponent.domain.model.htmlcomponent.HtmlComponent;
import com.htmlcomponent.domain.model.htmlcomponent.HtmlComponentNotFoundException;
import com.htmlcomponent.domain.model.htmlcomponent.HtmlComponentRepository;
import com.htmlcomponent.domain.model.htmlcomponent.Page;
import com.htmlcomponent.domain.model.htmlcomponent.PageNotFoundException;
import com.htmlcomponent.domain.model.htmlcomponent.PageRepository;
import com.htmlcomponent.domain.model.vo.HtmlContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class PageService {
  private PageRepository pageRepository;

  public PageService(final PageRepository pageRepository) {
    this.pageRepository = pageRepository;
  }

  @Transactional
  public void changePage(Long pageId, HtmlContent htmlContent) {
    Page page = pageRepository.findById(pageId)
        .orElseThrow(() -> new PageNotFoundException(pageId));

    page.changeHtmlContent("testAuthor", htmlContent);
  }
}