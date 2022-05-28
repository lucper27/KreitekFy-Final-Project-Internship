package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.StyleDTO;
import com.kreitek.kreitekfy.application.mapper.StyleMapper;
import com.kreitek.kreitekfy.application.service.StyleService;
import com.kreitek.kreitekfy.domain.entity.Style;
import com.kreitek.kreitekfy.domain.persistence.StylePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StyleServiceImpl implements StyleService {

    private final StylePersistence stylePersistence;

    private final StyleMapper styleMapper;
    @Autowired
    public StyleServiceImpl(StylePersistence stylePersistence, StyleMapper styleMapper) {
        this.stylePersistence = stylePersistence;
        this.styleMapper = styleMapper;
    }

    @Override
    public List<StyleDTO> getStylesByName(String partialName) {
        List<Style> styles = this.stylePersistence.getStylesByName(partialName);
        return this.styleMapper.toDto(styles);
    }
}
