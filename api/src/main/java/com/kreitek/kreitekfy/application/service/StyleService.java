package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.StyleDTO;

import java.util.List;

public interface StyleService {

    List<StyleDTO> getStylesByName(String partialName);
}
