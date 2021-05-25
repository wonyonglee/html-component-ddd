package com.htmlcomponent.domain.model.htmlcomponent;

import com.htmlcomponent.domain.model.TimeEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="htmlComponentPageAsset")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PageAsset extends TimeEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  private String name;
  @Column
  private String originName;
  @Column
  private String path;
  @Column
  private PageAssetType type;
  @ManyToOne
  @JoinColumn(name = "page_id", nullable = false, updatable = false)
  private Page page;

  @Builder
  public PageAsset(Page page, String name, String originName, String path, String type) {
    this.page = page;
    this.name = name;
    this.originName = originName;
    this.path = path;
    this.type = PageAssetType.findType(type);
  }
}