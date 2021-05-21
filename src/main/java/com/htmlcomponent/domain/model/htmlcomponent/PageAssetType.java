package com.htmlcomponent.domain.model.htmlcomponent;

import java.util.Arrays;

public enum PageAssetType {
  CSS,
  JS,
  IMAGE,
  VIDEO,
  ICON,
  FONT,
  EMPTY;

  public static PageAssetType findType(String typeName) {
    return Arrays
        .stream(PageAssetType.values())
        .filter(assetType -> assetType.name().equals(typeName))
        .findAny()
        .orElse(EMPTY);
  }
}