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
@Table(name="htmlComponentHistory")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class History extends TimeEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(length=20)
  private String type;
  @Column
  private String description;

  @ManyToOne
  @JoinColumn(name = "htmlcomponent_id", nullable = false, updatable = false)
  private HtmlComponent htmlComponent;

  @Builder
  public History(HtmlComponent htmlComponent, String type, String description) {
    this.htmlComponent = htmlComponent;
    this.type = type;
    this.description = description;
  }
}