package com.kreitek.kreitekfy.infraestructure.persistence;


import com.kreitek.kreitekfy.domain.entity.Style;
import com.kreitek.kreitekfy.domain.persistence.StylePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StylePersistenceImpl implements StylePersistence {

    private final StyleRepository styleRepository;
    @Autowired
    public StylePersistenceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public List<Style> getStylesByName(String partialName) {
        return this.styleRepository.findByNameContainsIgnoreCase(partialName);
    }
}
