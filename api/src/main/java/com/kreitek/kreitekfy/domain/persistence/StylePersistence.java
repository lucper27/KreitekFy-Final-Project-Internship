package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Style;
import java.util.List;

public interface StylePersistence {

    List<Style> getStylesByName(String partialName);
}
