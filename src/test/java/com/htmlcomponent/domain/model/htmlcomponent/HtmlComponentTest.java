package com.htmlcomponent.domain.model.htmlcomponent;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class HtmlComponentTest {
  @Autowired
  private HtmlComponentRepository htmlComponentRepository;

  @Test
  public void test_addHtmlComponent() {
    HtmlComponent sample = HtmlComponent
        .builder()
        .author("testAuthor")
        .name("testName")
        .build();
    sample = htmlComponentRepository.save(sample);

    assertEquals("testAuthor", sample.getAuthor());
  }
}