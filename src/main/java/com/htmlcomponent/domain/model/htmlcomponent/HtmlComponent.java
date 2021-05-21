package com.htmlcomponent.domain.model.htmlcomponent;

import com.htmlcomponent.domain.model.TimeEntity;
import com.htmlcomponent.domain.model.vo.HtmlContent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="htmlComponent")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HtmlComponent extends TimeEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Version
  private Long version;
  @Column(length=100)
  private String name;
  @Column(length=20)
  private String author;
  @Column
  private Long savedPageId;
  @Column
  private Long approvedPageId;

  @OneToMany(mappedBy = "htmlComponent", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Page> pages = new ArrayList<>();

  @Builder
  public HtmlComponent(String name, String author) {
    this.name = name;
    this.author = author;
  }

  public void addPage(HtmlContent htmlContent) {
    this.pages.add(
      Page
        .builder()
        .htmlComponent(this)
        .htmlContent(htmlContent)
        .build()
    );
  }

  public void changeSaveId(Long pageId) {
    this.savedPageId = pageId;
  }

  public void changeApprovedPageId(Long pageId) {
    this.approvedPageId = pageId;
  }
}