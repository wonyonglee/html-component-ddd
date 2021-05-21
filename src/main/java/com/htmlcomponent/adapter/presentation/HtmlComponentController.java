package com.htmlcomponent.adapter.presentation;

import com.htmlcomponent.application.service.HtmlComponentService;
import com.htmlcomponent.application.service.PageService;
import com.htmlcomponent.domain.model.htmlcomponent.HtmlComponent;
import com.htmlcomponent.domain.model.vo.HtmlContent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("html-component")
@AllArgsConstructor
public class HtmlComponentController {
  @Autowired
  HtmlComponentService htmlComponentService;

  @Autowired
  PageService pageService;

  @RequestMapping(method = RequestMethod.GET)
  public void sampleAddPage() {
    HtmlComponent htmlComponent = htmlComponentService.addHtmlComponent("asdfzxcv");
    htmlComponentService.addHtmlComponentPage(htmlComponent.getId(), HtmlContent.builder().css("css").js("js").html("html").build());
  }

  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public void sampleChangePage() {
    HtmlComponent htmlComponent = htmlComponentService.addHtmlComponent("asdfzxcv");
    pageService.changePage(Long.parseLong("1"), HtmlContent.builder().css("css1").js("js2").html("html3").build());
  }
}