package com.htmlcomponent.application.service;

import com.htmlcomponent.domain.model.htmlcomponent.HtmlComponent;
import com.htmlcomponent.domain.model.htmlcomponent.HtmlComponentNotFoundException;
import com.htmlcomponent.domain.model.htmlcomponent.HtmlComponentRepository;
import com.htmlcomponent.domain.model.htmlcomponent.Page;
import com.htmlcomponent.domain.model.vo.HtmlContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class HtmlComponentService {
  private HtmlComponentRepository htmlComponentRepository;

  public HtmlComponentService(final HtmlComponentRepository htmlComponentRepository) {
    this.htmlComponentRepository = htmlComponentRepository;
  }

  @Transactional
  public HtmlComponent addHtmlComponent(String author) {
    if (author.equals("")) return null;
    HtmlComponent htmlComponent = HtmlComponent.builder().author(author).build();
    return htmlComponentRepository.save(htmlComponent);
  }

  @Transactional
  public void addHtmlComponentPage(Long compId, HtmlContent htmlContent) {
    HtmlComponent htmlComponent = htmlComponentRepository.findById(compId)
        .orElseThrow(() -> new HtmlComponentNotFoundException(compId));

    htmlComponent.addPage(htmlContent);
  }
}