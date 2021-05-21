package com.htmlcomponent.domain.model.htmlcomponent;

import com.htmlcomponent.application.events.Events;
import com.htmlcomponent.domain.model.TimeEntity;
import com.htmlcomponent.domain.model.vo.HtmlContent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="htmlComponentPage")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Page extends TimeEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(length=20)
  private String author;
  @Embedded
  private HtmlContent htmlContent;

  @OneToMany(mappedBy = "page", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<PageAsset> assetList = new ArrayList<>();
  @ManyToOne
  @JoinColumn(name = "htmlcomponent_id", nullable = false, updatable = false)
  private HtmlComponent htmlComponent;

  @Builder
  public Page(HtmlComponent htmlComponent, String author, HtmlContent htmlContent) {
    this.htmlComponent = htmlComponent;
    this.author = author;
    this.htmlContent = htmlContent;
  }

  public void addPageAsset(String path, String name, String originName, String type) {
    this.assetList.add(
      PageAsset.builder()
        .path(path)
        .name(name)
        .originName(originName)
        .type(type)
        .page(this)
        .build()
    );
  }

  public void changeHtmlContent(String author, HtmlContent htmlContent) {
    this.author = author;
    this.htmlContent = htmlContent;

    Events.publish(new PageContentChanged(this, htmlContent));
  }
}